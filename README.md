<h2>Political Affiliation Survey</h2>


This program is designed as a political affiliation survey. It asks a series of questions, assigns scores based on answers, and then makes an educated guess about the user's political leaning. 

<h4>Constants Declaration:</h4>
'TOTAL_QUESTIONS': Total number of questions in the survey, set to 20.
<br/>
'GUESS_POINTS': An array of question numbers (10, 14, 18) reference points (question #) at which program will try to make guess on user's political stance
<br/>
'LIBERAL_THRESHOLD' and 'CONSERVATIVE_THRESHOLD': Average score thresholds for categorizing poliitical affiliation as Liberal or Conservative

<h4>Main Method:</h4>
Initializes 'Scanner' for user input and 'score' to keep track of the total score and a boolean 'guessed' to check if a guess has been made.
<br/>
Two arrays, 'questions' and 'options', to store they survey questions and their corresponding answer options.

<h4>Survey Execution:</h4>
The program iterates over the array which stores the questions and displays them along with the answer options. The user's response is read and converted to uppercase. The response is scored based on the option selected (A= 1 point, B= 2 points, C= 3 points, D= 4 points). If the input is invalid, it moves to the next question without scoring.

<h4>Guessing Political Affiliiation:</h4>
After each question, the program checks if it's at one of the pre-determined 'GUESS_POINTS' using the 'shouldMakeGuess()' method. If yes, it calculates the average score and makes an early guess about the political affiliation using 'getPoliticalAffiliationGuess()' method. If a guess is made, it breaks out of the loop. The program will make an early guess on user's political affiliation if the responses is in favor to one political affiliation from the total score exceeding thresholds. 

<h4>Final Guess:</h4>
If no early guess is made, after iterating through all questions, it calculates the average score based on all 20 questions and makes a final guess.

<h4>User's Actual Affiliation:</h4>
It then prompts the user to enter their actual political affiliation for survey purposes.
