#!/bin/bash

PROJECT_NAME="LibraryManagement"
MAIN_CLASS="main.Main"
SRC_DIR="src"
BIN_DIR="bin"
JAR_NAME="${PROJECT_NAME}.jar"
MANIFEST_FILE="meta/MANIFEST.MF"

echo "Creating output directories..."
mkdir -p "$BIN_DIR"
mkdir -p meta

echo "Compiling Java source files..."
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$BIN_DIR" @sources.txt
if [ $? -ne 0 ]; then
  echo "Compilation failed!"
  rm sources.txt
  exit 1
fi
rm sources.txt

echo "Creating manifest file..."
echo "Manifest-Version: 1.0" > "$MANIFEST_FILE"
echo "Main-Class: $MAIN_CLASS" >> "$MANIFEST_FILE"
echo "" >> "$MANIFEST_FILE"

echo "Packaging into JAR file..."
jar cfm "$JAR_NAME" "$MANIFEST_FILE" -C "$BIN_DIR" .
if [ $? -ne 0 ]; then
  echo "JAR creation failed!"
  exit 1
fi

echo "Cleaning up..."
rm -rf "$BIN_DIR" meta

echo "Build successful! JAR file created: $JAR_NAME"
