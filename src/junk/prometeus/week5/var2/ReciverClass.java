package junk.prometeus.week5.var2;

public class ReciverClass {
    private String str;

    public void setStr(String str) { this.str = str; }
    
    void help(){ System.out.println("Help executed"); }
    void echo(){ System.out.println(str); }
    void date(){ System.out.println(System.currentTimeMillis()); }
    void exit(){ System.out.println("Goodbye!"); }
}
