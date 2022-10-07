# FileManager

File manager is a Java application that helps to interact with files and directories from console

## Technologies

Project created with:
* Java version: 1.8
* Maven version: 3.0

## Commands

* `cd ..` returns to a parent directory
* `cd "directory"` finds child directory
* `hepl` returns a list of available commands
* `ls "chosen parameters"` creates a table of files in current directory by specified parameters `s r w e` (size, readable, writable, extension)
* `lsAll` creates table of files in current directory with all parameters as in `ls`
* `lstree "depth"` creates a tree of directories by specified depth
* `mkdir "directory name"` creates directory
* `mkfile "file name"` creates file
* `open "file"` opens file for reading
* `pwd` returns current path
* `rm "file name"` deletes file
* `rmr "directory name"` deletes directory recursively
* `write` writes input text to current file

## Setup

To run this project, install it locally

For tests running `mvn clean test` \
For project running `mvn tomcat:start`

