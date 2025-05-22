package jsonlib;

import jsonlib.types.JSONBoolean;
import jsonlib.types.JSONDict;
import jsonlib.types.JSONList;
import jsonlib.types.JSONNumber;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONString;

public class JSONParser {
  private String content;
  private int pos;

  public JSONParser(String content) {
    this.content = content;
    this.pos = 0;
  }

  private char peek() {
    if (pos >= 0 && pos < content.length())
      return content.charAt(pos);
    else
      return '\0';
  }

  private char consume() {
    char c = peek();

    if (c != '\0')
      pos++;

    return c;
  }

  private void consumeWhitespace() {
    while (peek() != '\0' && Character.isWhitespace(peek()))
      consume();
  }

  private void expect(String needed) throws JSONExpectFailedException {
    if (needed == null || needed.length() == 0)
      return;

    int i = 0;
    while (peek() != '\0' && i < needed.length()) {
      if (peek() != needed.charAt(i)) {
        throw new JSONExpectFailedException(String.format("Expected '%c', but found '%c'", needed.charAt(i), peek()));
      }

      i++;
      consume();
    }

    // it means we reached EOF before finishing the expected string
    // so we should throw an exception
    if (i < needed.length())
      throw new JSONExpectFailedException(String.format("Expected '%c', but reached EOF", needed.charAt(i)));
  }

  private JSONString parseString() throws JSONExpectFailedException {
    expect("\"");

    StringBuilder sb = new StringBuilder();

    while (peek() != '\0' && peek() != '"')
      sb.append(consume());

    expect("\"");

    return new JSONString(sb.toString());
  }

  private JSONNumber parseNumber() throws JSONExpectFailedException {
    int sign = 1;

    if (peek() == '-') {
      expect("-");
      sign = -1;
    }

    StringBuilder integerPartStr = new StringBuilder();
    StringBuilder floatingPartStr = new StringBuilder();
    boolean isFloat = false;

    while (peek() != '\0' && Character.isDigit(peek()))
      integerPartStr.append(consume());

    if (integerPartStr.length() == 0)
      throw new JSONExpectFailedException(String.format("Expected digit but found '%c'", peek()));

    if (peek() == '.') {
      expect(".");
      isFloat = true;
      while (peek() != '\0' && Character.isDigit(peek()))
        floatingPartStr.append(consume());

      if (floatingPartStr.length() == 0)
        throw new JSONExpectFailedException(String.format("Expected digit but found '%c'", peek()));
    }

    if (isFloat) {
      double number = Double.valueOf(integerPartStr + "." + floatingPartStr);
      return new JSONNumber<Double>(sign * number);
    } else {
      try {
        int number = Integer.valueOf(integerPartStr.toString());
        return new JSONNumber<Integer>(sign * number);
      } catch (NumberFormatException e) {
        long number = Long.valueOf(integerPartStr.toString());
        return new JSONNumber<Long>(sign * number);
      }
    }
  }

  private JSONList parseList() throws JSONExpectFailedException {
    expect("[");
    JSONList list = new JSONList();

    while (peek() != '\0' && peek() != ']') {
      JSONObject item = parse();
      list.add(item);

      consumeWhitespace();

      if (peek() != ']')
        expect(",");
    }

    expect("]");
    return list;
  }

  private JSONDict parseDict() throws JSONExpectFailedException {
    expect("{");
    JSONDict dict = new JSONDict();

    while (peek() != '\0' && peek() != '}') {
      consumeWhitespace();
      JSONString key = parseString();
      consumeWhitespace();
      expect(":");
      JSONObject value = parse();

      dict.put(key, value);

      consumeWhitespace();
      if (peek() != '}')
        expect(",");
    }

    expect("}");
    return dict;
  }

  private JSONBoolean parseBoolean() throws JSONExpectFailedException {
    if (peek() == 't') {
      expect("true");
      return new JSONBoolean(true);
    } else {
      expect("false");
      return new JSONBoolean(false);
    }
  }

  public JSONObject parse() throws JSONExpectFailedException {
    while (peek() != '\0') {
      switch (peek()) {
        case '[':
          return parseList();
        case '{':
          return parseDict();
        case '"':
          return parseString();
        default:
          if (Character.isDigit(peek()) || peek() == '-')
            return parseNumber();
          else if (Character.isWhitespace(peek()))
            consume();
          else if (peek() == 't' || peek() == 'f')
            return parseBoolean();
          else
            // TODO: handle invalid characters properly.
            throw new UnsupportedOperationException("not implemented yet");
          break;
      }
    }
    return null;
  }

}
