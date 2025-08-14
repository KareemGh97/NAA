package Utilities.Jira;

import io.cucumber.plugin.event.TestCaseFinished;
import net.rcarz.jiraclient.*;
import java.io.File;
import java.util.ArrayList;


public class JiraServiceProvider {
    public JiraClient jira;
    public String project;

    // THIS VALUE GET BY INSPECT THE NAME OF THIS ELEMENT
    public String CUSTOM_ACTUAL_RESULT_Field="customfield_10038";

    public String envField="environment";


    public JiraServiceProvider(
            String jiraUrl,
            String username,
            String password,
            String projectName)
    {
        BasicCredentials credentials = new BasicCredentials(username, password);
        jira = new JiraClient(jiraUrl, credentials);
        this.project = projectName;
    }

    public void createJiraTicket(
            String issueType,
            String summary,
            String description,
            String actualResult,
            String environment,
            ArrayList<String> label,
            String assignee,
            String priority,
            String linkIssue,
//            File file,
            String comment)
    {
        try{
            Issue.FluentCreate fluentCreate = jira.createIssue(project, issueType);
            fluentCreate.field(Field.SUMMARY, summary);
            fluentCreate.field(Field.DESCRIPTION, description +"\n"+ actualResult);
            fluentCreate.field(envField,environment);
            //fluentCreate.field(CUSTOM_ACTUAL_RESULT_Field, actualResult);
            fluentCreate.field(Field.LABELS, label);
            fluentCreate.field(Field.ASSIGNEE, assignee);
            fluentCreate.field(Field.PRIORITY, priority);
            Issue newIssue = fluentCreate.execute();
            newIssue.link(linkIssue, "Relates");//Blocks , Cloners , Duplicate , Relates
//            newIssue.addAttachment(file);
            newIssue.addComment(comment);
            System.out.println("new issue created in jira with ID" + newIssue);
        }catch(JiraException e){
            e.printStackTrace();
        }
    }

    public boolean isIssuePresent(TestCaseFinished event) {
        boolean flag = false;
        try{
            String scenarioName= event.getTestCase().getName()+" Is Failed";
            String jqlQuery = "project = \"XRAY\" and type = Bug and status in (\"In Progress\", \"To Do\") AND text ~ \"Automation - "+scenarioName+"\"";
            Issue.SearchResult searchResult =jira.searchIssues(jqlQuery);
            if (!searchResult.issues.isEmpty())
                flag=true;
        }catch(JiraException e){
            e.printStackTrace();
        }
        return flag;
    }



    public void changeIssueStatus(String issueKey,String Status) throws JiraException {
        Issue issue =jira.getIssue(issueKey);
        issue.transition().execute(Status);
    }


}
