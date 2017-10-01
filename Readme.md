
# Portfolio-Library
So you have developed full Application, Now the part comes when you are required to showcase your awesome projects but you feel terrible for creating something boilerplate. Now don't feel just write couple of lines about your projects and provide link to those projects and bamm you get the PortfolioActivity. 

<img src="https://github.com/HemantGTX950/Portfolio/blob/master/1.png" height="700" width="400" >


# Download

**Gradle**
# Min SDK
Minimum sdk is 16 and support is limited to recyclerview for now.

# Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
# Add the dependency
```
  compile 'com.github.HemantGTX950:Portfolio:v1.0.0'
```

# Usage

Use these block of code inside the onClick method of the Activity/Fragment from where you want to open the PortfolioActivity.

Step 1:

First of all create a list of projects by adding ProjectName, ProjectDescription and ProjectLink and mind that you should use the <b>Project</b> as a type of list.

```
         List<Project> projectList = new ArrayList<>();
 
         Project pollstap = new Project();
         pollstap.setProjectName("EC2017");
         pollstap.setProjectDesc("Annual Fest app to register for various events and manage your tickets.");
         pollstap.setProjectLink("https://play.google.com/store/apps/details?id=dev.elementsculmyca.ec2017");
 
         Project popupBubble = new Project();
         popupBubble.setProjectName("JustTouch");
         popupBubble.setProjectDesc("Android app to read and write into an NFC tag.");
         popupBubble.setProjectLink("https://github.com/HemantGTX950/JustTouch");
 
         projectList.add(pollstap);
         projectList.add(popupBubble);


```

Step 2:

Then create a list of DeveloperProfiles by adding ProfileLink & Icon and mind that you should use the <b>DeveloperProfile</b> as a type of list.

```

        List<DeveloperProfile> developerProfileList=new ArrayList<>();
        DeveloperProfile github=new DeveloperProfile();

        github.setIcon(R.drawable.github_logo);
        github.setProfileLink("https://github.com/HemantGTX950");

        DeveloperProfile linkedin=new DeveloperProfile();

        linkedin.setIcon(R.drawable.linkedin);
        linkedin.setProfileLink("https://www.linkedin.com/in/hemantbansal950");
        developerProfileList.add(github);
        developerProfileList.add(linkedin);


```



Step 3:

Pass this 'projectList' to the 'withProjectList()' method, 'developerProfileList'
  to the 'withProfiles()', and if you want your name to be shown in title bar pass your name in 
  'withDeveloperName()' method, then build and start to launch the activity.

```java
        new Portfolio.Builder(LandingActivity.this)
                .withProfiles(developerProfileList)
                .withProjects(projectList)
                .withDeveloperName("Hemant Bansal")
                .build()
                .start();

```

# License

```
MIT License

Copyright (c) 2017 Hemant Bansal

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
   
```
