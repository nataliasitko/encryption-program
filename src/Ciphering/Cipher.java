package Ciphering;

public abstract class Cipher {
    protected String text;

    public Cipher(){
        this.text = "";
    }

    public Cipher(String text){
        setText(text);
    }

    public void setText(String text) {
        if(text != null){
            this.text = text;
        }else{
            throw new IllegalArgumentException("Text cannot be null.");
        }
    }

    public abstract void setKey();
    public abstract String encrypt();

}
