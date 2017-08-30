package Books.sierra.page486;

class QuizCard {
    
    private String que, ans;

    private QuizCard() {
    }
    
    public QuizCard(String question, String answer ) {
        que = question;
        ans = answer;
    }
    
    public String getQuestion() {
        return que;
    }
    
    public String getAnswer() {
        return ans;
    }
    
}
