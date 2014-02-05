

# Test Plan Document – Team 25
## **1 Introduction**
The project sponsor has asked for the creation of an application that will analyze a student's essay and determine its average sentence length. The name of this software product will be the Average Sentence Length Application (ASLA). ASLA will be a single, stand-alone application that the user can run from a command line in a terminal window. The user will be able to specify the preferred delimiters as well as a word length limit. In order to analyze an essay, the user must use the command line to specify a file path to the essay. ASLA will scan the essay and output the average sentence length onto the user’s computer screen. If the application is run with no arguments, help information will be displayed on the screen. This application does not fix the spelling or grammatical errors of the essay, and it does not provide an overall word count.

## **2 Quality Control**

### **2.1 Test Plan Quality**
Every functional requirement will have a corresponding test in the test plan and unit test in source code.  When possible, any non-functional requirements will also have corresponding tests.  Subjective requirements will be given objective, measurable goals that can be tested in an automated fashion.  The test plan will be reviewed by multiple team members to ensure completeness. 

### **2.2 Adequacy Criterion**
The following will be used to evaluate the completion of all test activities:

 - All unit tests pass
 - All test cases in the test plan pass
 - Code coverage is at 90% or higher



### **2.3 Bug Tracking**
Bugs will be tracked in a spreadsheet.

Enhancement requests will be tracked as new documents in the project specifying the following:

 - Details of the new requirement to be implemented
 - Test plan for the enhancement
 - Architecture and Design impact of the enhancement
 - Estimated time and cost associated with implementing the enhancement
 - Acceptance criteria of the enhancement




## **3 Test Strategy**

### **3.1 Testing Process**
Unit tests will be written by the developer.  Any bugs found should generate a new (failing) unit test to reproduce the bug reported, as well as having a new entry in the test plan.  Regression testing will be done by running all unit tests.  When this process is followed, we can be sure that any older bugs stay fixed when changes are made to correct new bugs.

The Test plan will be executed by the Tester as outlined in the Process Plan.  The test plan may be done manually or implemented in an automated fashion.

### **3.2 Technology**
JUnit will be used to test all functionality.  EclEmma will be used to measure code coverage of the tests.

## **4 Test Cases**
Provides a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result, pass/fail information, and any additional information you think is relevant.

<table>
<tbody>

    <tr>
        <td><b>#</b></td>
        <td><b>Requirements Cross Reference</b></td>
        <td><b>Purpose</b></td>
        <td><b>Test Steps</b></td>
        <td><b>Expected Result</b></td>
        <td><b>Actual Result</b></td>
        <td><b>Pass/Fail</b></td>
    </tr>
    
    <tr>
        <td><b>1</b></td>
        <td>n/a</td>
        <td>Test 1.0 Pre-test Setup</td>
        <td>

<p> 1.) Copy essay.txt and essay2.txt files to local system. Record the <path> where the file resides</p>
 2.) Navigate to the directory where the ASLA application resides.

    </td>
        

    
        <td>n/a</td>
        <td>n/a</td>
        <td>n/a</td>
    </tr>
    
    <tr>
    <td><b> 2</b></td>
    <td>3.1.1</td>
    <td>Verify simple execution from a command line</td>
    <td>3.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "." -l "3"</td>
    <td>6</td>
    <td>6</td>
    <td>Pass</td>
    
    </tr>

 <tr>
    <td><b> 3</b></td>
    <td>3.1.3</td>
    <td>Verify single delimiter</td>
    <td>4.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "?" -l "3"</td>
    <td>10</td>
    <td>10</td>
    <td>Pass</td>
    
    </tr>
    
    
 <tr>
    <td><b> 4</b></td>
    <td>3.1.3</td>
    <td>Verify multiple delimiters</td>
    <td>5.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "?","." -l "3"</td>
    <td>5</td>
    <td>5</td>
    <td>Pass</td>
    
    </tr>
    
     <tr>
    <td><b> 5</b></td>
    <td>3.1.4</td>
    <td>Verify minimum word length = 2</td>
    <td>6.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "?","." -l "2"</td>
    <td>6</td>
    <td>6</td>
    <td>Pass</td>
    
    </tr>
    
 <tr>
    <td><b>6 </b></td>
    <td>3.1.4</td>
    <td>Verify minimum word length = 4</td>
    <td>7.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "?","." -l "4"</td>
    <td>4</td>
    <td>4</td>
    <td>Pass</td>
    
 </tr>
    
    <tr>
    <td><b>7 </b></td>
    <td>3.1.3, 3.1.4</td>
    <td>Verify minimum word length with different delimiter</td>
    <td>8.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "?" -l "2"</td>
    <td>12</td>
    <td>12</td>
    <td>Pass</td>
    
    </tr>
    
 <tr>
    <td><b>8</b></td>
    <td>3.1.5, 3.1.6</td>
    <td>Verify that a sentence with words less than the delimiter are not counted in average sentence length. 
This test also verifies the average sentence length being rounded down to the nearest integer.</td>
    <td>9.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay2.txt -d "." -l "4"</td>
    <td>13</td>
    <td>13</td>
    <td>Pass</td>
    
    </tr>

<tr>
    <td><b>9 </b></td>
    <td>2.2.2.3</td>
    <td>Verify response when length parameter missing (Default -l = 3)</td>
    <td>10.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\essay.txt -d "."</td>
    <td>6</td>
    <td>6</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b>10 </b></td>
    <td>3.1.7.1</td>
    <td>Verify response when no  parameters are specified
(No file, no delimiter, no length)</td>
    <td>11.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA

Expected Output (EO) = Usage: ASLA <filename> [-d <sentence delimiter characters>] [-l <minimum word length>]</td>
    <td>EO</td>
    <td>EO</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b>11 </b></td>
    <td>3.1.7.2</td>
    <td>Verify response when no filename specified</td>
    <td>12.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA -d "." -l "4"

Expected Output (EO) = The specified file could not be found.</td>
    <td>EO</td>
    <td>EO</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b>12 </b></td>
    <td>3.1.2.1</td>
    <td>Verify response when file is invalid or missing</td>
    <td><p>13.) Ensure that a file named ‘widget.txt’ is not in the specificed path </p>
14.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\widget.txt -d "?","." -l "4"

Expected Output (EO) = The specified file could not be found.</td>
    <td>EO</td>
    <td>EO</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b> 13</b></td>
    <td>3.1.2.2</td>
    <td>Verify response when file type is binary</td>
    <td><p>15.) Locate the ASLA.class file. Record the <path> where the file resides.</p>

<p>16.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\ASLA.class -d "?","." -l "4"</p>

<p>Expected Output (EO) = The average sentence length of the <path>\ASLA.class file is
X words.</p>

NOTE: Number of words is irrelevant. Test is to determine </td>
    <td>EO</td>
    <td>EO</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b>14 </b></td>
    <td>3.1.2.3</td>
    <td>Verify the response when a file size larger than 5 mb is used</td>
    <td><p>17.) Locate a <file> on the execution system larger than 5 mb. Record the <path> where the file resides.</p>

<p>18.) Enter the following command:
java edu.gatech.omscs.team25.project1.ASLA <path>\<file> -d "?","." -l "4"</p>

Expected Output (EO) = The specified file exceeds the limit of 5 MB.</td>
    <td>EO</td>
    <td>EO</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b>15 </b></td>
    <td>3.2.1</td>
    <td>Verify application execution performance</td>
    <td><p>19.) Start a timer (watch or scripted command)</p>
    <p>20.) Execute the following command:
java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "." -l "3"</p>
<p>21.) Stop the timer (watch or scripted command)</p></td>
    
    <td>< 5 sec</td>
    <td>0.13 sec
Ave.</td>
    <td>Pass</td>
    
    </tr>
    
<tr>
    <td><b> </b></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    
    </tr>


</tbody>
</table>


### **4.1 Test Files**
The following table contains content that was used in the execution of the tests outlined in section 4.  These files should be created as a local file on the test machine.

<table>
<tbody>

<tr>
    <td><b>ID</b></td>
    <td><b>File Name</b></td>
    <td><b>File Content</b></td>
</tr>


<tr>
    <td>1.0</td>
    <td>essay.txt</td>
    <td><p>7 66 555 4444 33333 222222 1111111.</p>
    <p>7 66 555 4444 33333 222222 1111111?</p>
    <p>7 66 555 4444 33333 222222 1111111.</p>
    7 66 555 4444 33333 222222 1111111? </td>
    

</tr>

<tr>

    <td> 1.1 </td>
    <td>essay2.txt</td>
    <td><p>The following sentence is a short sentence that will not get counted in the average with the minimum delimiter (-l) =4.</p>
    <p>I put my red fox in a big box of ice.</p>
    Since the above line was made of words that were all smaller than 4, it will not be used in the average sentence length calculation.</td>

</tr>

</tbody>
</table>

### **4.2 Unit Test Identification**
The following unit tests will be executed as part of this Test Plan.  

 - main_FileWithAllShortWords_GivesCorrectAnswer
 - main_HappyPathSimpleFile_GivesCorrectAnswer
 - main_HappyPathSimpleFileWithCustomDelimiters_GivesCorrectAnswer
 - main_HappyPathSimpleFileWithLowerMinimumSize_GivesCorrectAnswer
 - main_ImproperLOption_DisplaysError
 - main_MissingDValue_IgnoresAndWordsAnyway
 - main_MissingFile_ReturnsMissingFileError
 - main_MissingLValue_IgnoresAndWordsAnyway
 - main_NoArguments_DisplaysHelp
 - main_SuperBigFile_FinishesInTime
 - loadFile_InvalidFileName_ReturnsNull
 - validate_File1ByteShortOfTooBig_ReturnsTrue
 - validate_FileTooBig_ReturnsFalseAndPrintsError
 - validate_NullFileName_ReturnsFalseAndPrintsError


### **4.3 Example Test Execution Output**
The following is an output of the tests executed as part of this Test Plan.  

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "." -l "3"
The average sentence length of the c:\workspace\essay.txt file is 6 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "?" -l "3"
The average sentence length of the c:\workspace\essay.txt file is 10 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "?","." -l "3"
The average sentence length of the c:\workspace\essay.txt file is 5 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "?","." -l "2"
The average sentence length of the c:\workspace\essay.txt file is 6 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "?","." -l "4"
The average sentence length of the c:\workspace\essay.txt file is 4 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "?" -l "2"
The average sentence length of the c:\workspace\essay.txt file is 12 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay2.txt -d "." -l "4"
The average sentence length of the c:\workspace\essay2.txt file is 13 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\essay.txt -d "."
The average sentence length of the c:\workspace\essay.txt file is 6 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA
Usage: ASLA <filename> [-d <sentence delimiter characters>] [-l <minimum word length>]

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA -d "." -l "4"
The specified file could not be found.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA c:\workspace\widget.txt -d "." -l "4"
The specified file could not be found.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA C:\Workspace\GT\CS6300\Project_1\Google_Docs
_Copy\src\ASLA\src\edu\gatech\omscs\team25\project1\ASLA.class -d "." -l "2"
The average sentence length of the C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src\edu\gatech\omscs\team25\project1\ASLA.class file is
4 words.

C:\Workspace\GT\CS6300\Project_1\Google_Docs_Copy\src\ASLA\src>java edu.gatech.omscs.team25.project1.ASLA "C:\Users\BobHembree\Documents\Bob\Georgia T
ech\Spring_2014\CS6300-Software Development Process\P1 Notes\CS6300_P1 Lesson 2 - Life Cycle Models Notes.odp" -d "." -l "2"
The specified file exceeds the limit of 5 MB.
23:27:57.18
The average sentence length of the c:\workspace\essay.txt file is 6 words.
23:27:57.30


