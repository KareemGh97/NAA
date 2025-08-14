package Utilities.Jira;


import Utilities.Reader.DataReaderManager;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestStep;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class BugComponents {
    File recordedVideo;
    JiraServiceProvider jsp;

    public void createBugOnJira(TestCaseFinished event) {
            jsp = new JiraServiceProvider(getJiraUrl(), getJiraUserName(), getJiraPassword(), getProjectName());
            if (!jsp.isIssuePresent(event)) {
                String label = "Smoke_Mobile_Automation";
                jsp.createJiraTicket(
                        "Bug",
                        bugSummary(event),
                        bugDescription(event),
                        bugActualResult(event),
                        "Sit",
                        new ArrayList<>() {{add(label);}},
                        assignee(),
                        bugPriority(event),
                        linkIssue(event),
                        //bugVideo(event),
                        bugComment(event));
            }

    }




    public String getScenarioTagValue(TestCaseFinished event,String tagValue){
        String value = null;
        for (String tag:event.getTestCase().getTags()){
            if (tag.startsWith("@"+tagValue+"_")) {
                value = tag.substring(tag.indexOf("_") + 1);
            }
        }return value;
    }
    public String bugComment(TestCaseFinished event){
        return "Automated bug related to "+getScenarioTagValue(event,"TEST");
    }
    public String bugSteps(TestCaseFinished event){
        List<TestStep> testSteps=event.getTestCase().getTestSteps();
        List<String> TestCaseSteps =new ArrayList<>();
        for (TestStep testStep:testSteps){
            if (testStep instanceof PickleStepTestStep){
                PickleStepTestStep pickleStepTestStep = (PickleStepTestStep) testStep;
                String stepText=pickleStepTestStep.getStep().getText();
                TestCaseSteps.add(stepText);
            }
        }

        return String.join("\n",TestCaseSteps);
    }


    public String bugDescription(TestCaseFinished event){
        return "Description: "+bugSummary(event)+" due some assertions or exceptions"+"\n"+"Steps to reproduce bug:"+"\n"+ bugSteps(event);
    }
    public String bugSummary(TestCaseFinished event) {return "Automation - "+event.getTestCase().getName() + " Is Failed";
    }
    public String bugActualResult(TestCaseFinished event){
        return "Actual result:"+"\n"+ event.getResult().getError().toString();
    }
    public File bugVideo(TestCaseFinished event){
        return recordedVideo = new File(System.getProperty("user.dir") + "/videos/" + event.getTestCase().getName()+ "-null" + ".mp4");
    }
    public String bugPriority(TestCaseFinished event){return getScenarioTagValue(event, "Priority");
    }
    public String linkIssue(TestCaseFinished event){return getScenarioTagValue(event, "TEST");
    }
    public String getJiraUrl(){return DataReaderManager.data("JiraCredentials").getProperty("JiraUrl");
    }
    public String getJiraUserName(){return DataReaderManager.data("JiraCredentials").getProperty("JiraUsername");
    }
    public String getJiraPassword(){return DataReaderManager.data("JiraCredentials").getProperty("JiraPassword");
    }
    public String getProjectName() {
        return DataReaderManager.data("JiraCredentials").getProperty("JiraProject");

    }
    public String assignee(){
        return getJiraUserName();
    }



}
