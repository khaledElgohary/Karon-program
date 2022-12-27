import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class A3ElgoharyKhaled {
    public static void main(String[] args){

        String fileName="A3smallData.txt";//put your filename here between parenthesis
        Dictionary x=new Dictionary();
        try{
            FileReader m=new FileReader(fileName);
            BufferedReader file=new BufferedReader(m);
            Scanner lineReader=new Scanner(file.readLine());
            String error="";
            int counter=0;
            int val1=0;
            int val2=0;
            Node var1=null;
            Node var2=null;
            Node var3=null;
            String variableCheck="";
            String variableCheck2="";
            String variable1="";
            String op="";
            boolean insertion1=true;
            boolean insertion2=true;
            int progN= lineReader.nextInt();
            lineReader=new Scanner(file.readLine());
            //for loop is used to reset the table when it goes to the next program
            for(int i=0;i<progN;i++){
                x.resetTable();
                /*this while loop is responsible for executing several scenarios
                 * 1st scenario is a variable being declared or a variable already in hash table and updated with another
                 * number.
                 * 2nd scenario is a variable being declared or updated and it's calculation involves getting another
                 * variable from the hash table and performing an operation involving a number and the variable gotten
                 * from the hash table.
                 * 3rd scenario is a variable being declared or updated and it's calculation involves getting another
                 * 2 variables from the hash table and performing on those 2 values  */
                while(counter<progN){
                    if(lineReader.hasNext()){
                        variable1= lineReader.next();
                        var1=x.search(variable1);
                        if(lineReader.hasNext()&&var1==null){
                            lineReader.next();
                            if(lineReader.hasNextInt()){
                                val1= lineReader.nextInt();
                                if(!lineReader.hasNext()){
                                    x.insert(variable1,val1);
                                }
                                else {
                                    op= lineReader.next();
                                    if(lineReader.hasNextInt()){
                                        val2= lineReader.nextInt();
                                    }
                                    if(op.equals("+")){
                                        x.insert(variable1,val1+val2);
                                    }
                                    else if(op.equals("-")){
                                        x.insert(variable1,val1-val2);
                                    }
                                    else if(op.equals("*")){
                                        x.insert(variable1,val1*val2);
                                    }
                                    else if(op.equals("/")){
                                        if(val2==0){
                                            System.out.println("division operation can't be executed because "+variableCheck2+" holds value 0");
                                        }
                                        else{
                                            x.insert(variable1,val1/val2);
                                        }
                                    }
                                }
                            }
                            else{
                                variableCheck= lineReader.next();
                                var2=x.search(variableCheck);
                                if(var2==null){
                                    error=error+" this variable "+"("+variableCheck+")"+" is not present in our table and it entered a calculation without being declared"+"\n";
                                    insertion1=false;
                                }
                                else{
                                    val1=Integer.parseInt(var2.next.item);
                                }
                                if(lineReader.hasNext()){
                                    op= lineReader.next();
                                    if(lineReader.hasNextInt()){
                                        val2= lineReader.nextInt();
                                    }
                                    else{
                                        variableCheck2= lineReader.next();
                                        var3=x.search(variableCheck2);
                                        if(var3==null){
                                            error=error+" this variable "+"("+variableCheck2+")"+" is not present in our table and it entered a calculation without being declared"+"\n";
                                            insertion2=false;
                                        }
                                        else{
                                            val2=Integer.parseInt(var3.next.item);
                                        }
                                    }
                                    if(op.equals("+")&&(insertion1&&insertion2)){
                                        x.insert(variable1,val1+val2);
                                    }
                                    else if(op.equals("-")&&(insertion1&&insertion2)){
                                        x.insert(variable1,val1-val2);
                                    }
                                    else if(op.equals("*")&&(insertion1&&insertion2)){
                                        x.insert(variable1,val1*val2);
                                    }
                                    else if(op.equals("/")&&(insertion1&&insertion2)){
                                        if(val1!=0&&val2==0){
                                            System.out.println("there is a division by 0 in this program");
                                        }
                                        else{
                                            x.insert(variable1,val1/val2);
                                        }
                                    }
                                }
                                else if(insertion1 &&insertion2){
                                    x.insert(variable1,val1);
                                }
                            }
                        }//
                        else if(lineReader.hasNext()&&var1!=null){
                            lineReader.next();
                            if(lineReader.hasNextInt()){
                                val1= lineReader.nextInt();
                                if(!lineReader.hasNext()){
                                    x.updateValue(variable1,val1);
                                }
                                else{
                                    op= lineReader.next();
                                    if(lineReader.hasNextInt()){
                                        val2= lineReader.nextInt();
                                    }
                                    else{
                                        variableCheck= lineReader.next();
                                        var2=x.search(variableCheck);
                                        if(var2==null){
                                            error=error+" this variable "+"("+variableCheck+")"+" is not present in our table and it entered a calculation without being declared"+"\n";
                                            insertion1=false;
                                        }
                                        else{
                                            val2=Integer.parseInt(var2.next.item);
                                        }
                                    }
                                }
                            }
                            else if(lineReader.hasNext()){
                                variableCheck= lineReader.next();
                                var2=x.search(variableCheck);
                                if(var2==null){
                                    insertion1=false;
                                    error=error+" this variable "+"("+variableCheck+")"+" is not present in our table and it entered a calculation without being declared"+"\n";
                                }
                                else{
                                    val1=Integer.parseInt(var2.next.item);
                                }
                                if(!lineReader.hasNext()){
                                    x.updateValue(variable1,val1);
                                }
                                else{
                                    op= lineReader.next();
                                    if(lineReader.hasNextInt()){
                                        val2= lineReader.nextInt();
                                    }
                                    else{
                                        variableCheck2= lineReader.next();
                                        var3=x.search(variableCheck2);
                                        if(var3==null){
                                            error=error+" this variable "+"("+variableCheck2+")"+" is not present in our table and it entered a calculation without being declared"+"\n";
                                            insertion2=false;
                                        }
                                        else{
                                            val2=Integer.parseInt(var3.next.item);
                                        }
                                    }
                                }
                            }
                            if(op.equals("+")&&(insertion1&&insertion2)){
                                x.updateValue(variable1,val1+val2);
                            }
                            else if(op.equals("-")&&(insertion1&&insertion2)){
                                x.updateValue(variable1,val1-val2);
                            }
                            else if(op.equals("*")&&(insertion1&&insertion2)){
                                x.updateValue(variable1,val1*val2);
                            }
                            else if(op.equals("/")&&(insertion1&&insertion2)){
                                x.updateValue(variable1,val1/val2);
                            }
                        }
                    }
                    lineReader=new Scanner(file.readLine());
                    if(variable1.equals("Q")){
                        System.out.println("Karon program: "+counter);
                        System.out.println("list of errors:"+error);
                        System.out.println("-----------");
                        x.printVariables();
                        System.out.println("-----------");
                        x.resetTable();
                        counter=counter+1;
                        variableCheck="";
                        variableCheck2="";
                        error="";
                        if(!lineReader.hasNext()){
                            variable1="";
                        }
                    }
                    variableCheck="";
                    variableCheck2="";
                }
                x.resetTable();
            }
        }catch(IOException c){
            c.getMessage();
            c.printStackTrace();
            c.toString();
        }
    }
}
// below is the node class responsible for creating nodes and assigning it a value
class Node{
    public String item;
    public Node next;
    public Node(String newItem,Node newNext){
        item=newItem;
        next=newNext;
    }
}
//below class is the class responsible for creating hash table and contain all the necessary methods to implement it
class Dictionary {
    private static final int TABLESIZE=79;
    private Node[] hashArray;
    public Dictionary(){
        hashArray=new Node[TABLESIZE];
        for(int i=0;i<TABLESIZE;i++){
            hashArray[i]=null;
        }
    }
    //below method contain formula used to formulate hash code
    private int hash(String key){
        int a=23;
        int code=key.charAt(0);
        for(int i=1;i<key.length();i++){
            code=(code*a)+key.charAt(i);
        }
        if(code<0){
            code=-code;
        }
        code=code%(TABLESIZE);
        return code;
    }
    // below method is used to search for the variable in the hash table
    public Node search(String key){
        int pos=hash(key);
        Node curr=hashArray[pos];
        if(curr!=null&&curr.item.equals(key)){
            return curr;
        }
        else{
            if(curr!=null&&curr.next.next!=null){
                curr=curr.next.next;
            }
            while(curr!=null&&curr.next!=null){
                if(curr.item.equals(key)){
                    return curr;
                }
                else{
                    curr=curr.next.next;
                }
            }
        }
        return null;
    }
    //below method is used to insert a variable into the hash table
    public void insert(String variableName,int newItem){
        int pos=hash(variableName);
        Node curr=hashArray[pos];
        hashArray[pos]=new Node(Integer.toString(newItem),hashArray[pos]);
        hashArray[pos]=new Node(variableName,hashArray[pos]);
    }
    // below method is used to updateValue in the hash table
    public void updateValue(String variableName,int newItem){
        int pos=hash(variableName);
        Node curr=hashArray[pos];
        if(curr.item.equals(variableName)){
            String x=Integer.toString(newItem);
            curr.next.item=x;
        }
        else{
            if(curr.next.next!=null){
                curr=curr.next.next;
            }
            while(curr.next.next!=null){
                if(curr.item.equals(variableName)){
                    String x=Integer.toString(newItem);
                    curr.next.item=x;
                }
                curr=curr.next.next;
            }
        }
    }
    // below method is used to print all the value in the hash table
    public void printVariables(){
        Node curr=null;
        for(int i=0;i<hashArray.length;i++){
            curr=hashArray[i];
            while(curr!=null){
                System.out.println(curr.item+" = " +curr.next.item);
                curr=curr.next.next;
            }
        }
    }
    // below method is used to reset all the nodes in the hash tables
    public void resetTable(){
        for(int i=0;i<hashArray.length;i++){
            hashArray[i]=null;
        }
    }
}

