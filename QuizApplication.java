import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
public class QuizApplication extends Frame implements ActionListener {
    private Label questionLabel;
    private CheckboxGroup options;
    private Checkbox[] answerOptions;
    private Button submitButton;
	//array of questions
    private String[] questions={
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "What is the largest mammal on Earth?"
    };
	//array of options
    private String[][] answerChoices={
        {"Berlin", "London", "Paris"},
        {"Venus", "Mars", "Jupiter"},
        {"African Elephant", "Blue Whale", "Giraffe"}
    };
	//index of correct answers,1 index based
    private int [] correctAnswers={3, 2, 2};
    private int currentQuestion=0;
    private int score=0;
    private Timer timer;
	// time for a question in seconds 
    private int timeLeft=10;
    public QuizApplication(){
		//parameters of the main window on which the application is viewed
        setTitle("Quiz Application");
        setSize(800,700);
        setLayout(new FlowLayout());
        setResizable(true);
        questionLabel=new Label();
        add(questionLabel);
        options=new CheckboxGroup();
        answerOptions=new Checkbox[3];
        for (int i=0;i<3;i++){
            answerOptions[i] = new Checkbox();
            answerOptions[i].setCheckboxGroup(options);
            add(answerOptions[i]);
        }
        submitButton=new Button("Submit");
        submitButton.addActionListener(this);
        add(submitButton);
        timer=new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (timeLeft>0){
                    timeLeft--;
                } else {
					//timeout, when no answer selected (-1)
                    checkAnswer(-1);
                }
            }
        });
        nextQuestion();
        setVisible(true);
    }
    private void nextQuestion(){
		//conditions to display next questions
        if (currentQuestion<questions.length){
            questionLabel.setText(questions[currentQuestion]);
            for (int i=0;i<3;i++){
                answerOptions[i].setLabel(answerChoices[currentQuestion][i]);
                answerOptions[i].setState(false);
            }
            submitButton.setEnabled(true);
            timeLeft=10;
            timer.restart();
        } else {
            showResult();
        }
    }
    private void checkAnswer(int selectedOption){
        //chevking for the correct answers
		timer.stop();
        int correctAnswer=correctAnswers[currentQuestion];
        if (selectedOption==correctAnswer){
            score++;
        }
        currentQuestion++;
        nextQuestion();
    }
    private void showResult(){
		//showing user, the result
        removeAll();
		//parameters of the result window
        setLayout(new GridLayout(2, 1));
        Label resultLabel=new Label("Quiz Finished! You Scored: "+score+" out of "+questions.length);
        resultLabel.setAlignment(Label.CENTER);
        add(resultLabel);
        Button exitButton=new Button("Exit");
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        add(exitButton);
        pack();
    }
	//main method
    public static void main(String[] args){
        new QuizApplication().addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e){
        submitButton.setEnabled(false);
        for (int i=0;i<3;i++){
            if (answerOptions[i].getState()){
				//index of selected option, 1 index based
                checkAnswer(i+1);
                break;
            }
        }
    }
}