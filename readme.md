# Find Parent Challenge #

Given an input that represents a filesystem, and two files, find the closest folder that contains both file paths.

## Project Structure ##

- Code: src/main/java/challenge
- Test: src/test/java/challenge
- Lenguage: Java
- Tests Framework: JUnit
- Build tool: Maven

## Solution Explanation ##

The findParent method receives 3 parameters:

filesystem: An object representing a file system.
file1: An object representing a file.
file2: Another object representing a file.
First, it checks if any of the parameters is null, in which case an exception is returned.

Then, the getPath() method is used to obtain the path from the root to each of the files (if the path cannot be obtained, null is returned).

The getPath() method is a recursive function that traverses the file system. Once it finds the desired file, the complete path is returned.

Once the findParent() method has both paths, it iterates through them to find the deepest common directory (ignoring the files received as parameters). If they do not have a common directory, null is returned.

Finally, the name of the found parent directory is printed and returned.