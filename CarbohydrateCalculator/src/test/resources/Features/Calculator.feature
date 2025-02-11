Feature: Carbohydrate Calculator

Scenario Outline: Validate result is calculated when the user inputs valid fields
Given User is on Carbohydrate Calculator
When the user enters the fields <Age> <Gender> <Height> <Weight> <Activity>
And the user clicks on Submit
Then the result is calculated correctly
Examples:
|Age| Gender | Height | Weight | Activity |
|"22"	|	"Female" |	"160"  |	"100"		|"Sedentary: little or no exercise"		|			


Scenario Outline: Validate result is calculated when the user inputs invalid fields
Given User is on Carbohydrate Calculator
When the user enters the fields <Age> <Gender> <Height> <Weight> <Activity>
And the user clicks on Submit
Then the correct <Error Message> should be seen
Examples:
|Age| Gender | Height | Weight | Activity |Error Message|
|"2"	|	"Female" |	"160"  |	"100"		|"Sedentary: little or no exercise"		|		"Please provide an age between 18 and 80."|
|"20"	|	"Female" |	"0"  |	"100"		|"Sedentary: little or no exercise"		|		"Please provide positive height value."|