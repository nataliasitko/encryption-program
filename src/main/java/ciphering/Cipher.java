package ciphering;

public abstract class Cipher {
    protected String text;
    protected StringBuilder sb;

    public Cipher(String text){
        setText(text);
        this.sb = new StringBuilder();
    }

    private void setText(String text) {
        if(text != null){
            this.text = text;
        }else{
            throw new IllegalArgumentException("Text cannot be null.");
        }
    }

    public abstract String encrypt();

}
