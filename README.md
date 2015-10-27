UniMapperGenerator
===

Requirements
---

* [Eclipse](https://eclipse.org/)
* [Xtext](http://www.eclipse.org/Xtext/)
* [Xtend](http://www.eclipse.org/xtend/)

How to Develop
---

### 1. Install Xtext & Xtend
1. Visit [download page](http://www.eclipse.org/modeling/tmf/downloads/) in Xtext web site
2. Download the zip file of "2.7.3 All in one update site" in the column "show all 20..."
    + **DO NOT install the latest version.** It is not supported. 
3. Open Eclipse
4. Choose "help" -> "install new software" in the menu
5. Press "add" -> "archive" button in the window
6. Select the zip file that you downloaded now
7. Check the check boxes of Xtext and Xtend and press install button
8. If you see the "Install Remediation Page", choose "Update my installation to be compatible with the items being installed".
9. Restart eclipse

### 2. Import UniMapperGenerator
1. Clone [UniMapperGenerator](https://github.com/UnicoenProject/UniMapperGenerator).
2. Choose "File" -> "Import" in the menu
3. Choose "General" -> "projects from workspace" in the window
4. Import 4 projects that starts with "net.unicoen.unimappergenerator"
    + net.unicoen.unimappergenerator
    + net.unicoen.unimappergenerator.sdk
    + net.unicoen.unimappergenerator.tests
    + net.unicoen.unimappergenerator.ui
5. Right click the GeneratorUniMapperGenerator.mwe2 file in net.unicoen.unimappergenerator/src/net.unicoen directory
6. Select "Run as" -> "MWE2 Workflow"
    + If you can't build correctly, see [here](https://github.com/UnicoenProject/UniMapperGenerator/issues/3).

### 3. Import ANTLR4 binary file into project
1. Visit [download page](http://www.antlr.org/download.html) in ANTLR web site
2. Click "Complete ANTLR 4.5.1 Java binaries jar" link, and download the latest version of ANTLR 4.
3. Copy the downloaded file into net.unicoen.unimappergenerator/src directory.

