package ciphering;

public class RailFenceCipher extends Cipher{
    private int key;

    public RailFenceCipher(String text){
        super(text);
        setKey();
    }

    public int getKey() {
        return this.key;
    }

    protected void setKey() {
        this.key = 3;
    }


    protected String processText(int key) {

        char [][] railFence = new char[key][this.text.length()];
        boolean goDown = false;

        int row = 0;
        for(int col = 0; col < this.text.length(); col++){
            if(row == 0 || row == key - 1){
                goDown = !goDown;
            }
            railFence[row][col] = this.text.charAt(col);
            if(goDown){
                row++;
            }else{
                row--;
            }
        }

        for(char[] r : railFence){
            for(char ch : r){
                if((int)ch != 0){
                    this.sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    @Override
    public String encrypt(){
        return processText(this.key);
    }
}
