import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class builtin {
    // java predefined 
    public static void main(String[] args) {
        //  Scanner sc = new Scanner(System.in);
        // // BufferedReader = new BufferedReader(new Reader(System.in));
        // String str = sc.next();
        // System.out.println(str);
        // // String method index vasan 5
        // System.out.println(str.length()+" "+str.charAt(2)+" "+str.toLowerCase()+" "+str.toUpperCase()+" "+str.equals("vasan")+" "+str.equalsIgnoreCase("vasan"));
        // int[] arr = {1, 2, 3, 4};
        // System.out.println(arr.length+" "+arr[2]+" "+arr.toString()+ " "+ arr.hashCode());
        // System.out.println(Math.sqrt(4)+" "+Math.pow(3, 2)+" "+ Math.tan(45));
        // sc.close();
        // String str = new String("hai");
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(1, 4);
        // // array(ststic) array list(dynamic)
        // System.out.println(list);
        // list.remove(2);
        // System.out.println(list);
        // ArrayList<Integer> a1=new ArrayList<>();
        // a1.add(1);
        // a1.add(4);
        // System.out.println(list.containsAll(a1));
        // HashMap class 1 arjun 2 arun 3 sidarth
        // HashMap<Integer, String> rno = new HashMap<>();
        // rno.put(1, "arjun");
        // rno.put(2,"arun");
        // rno.put(3, "sidarth");
        // System.out.println(rno.get(1));
        // rno.remove(1);
        // System.out.println(rno);
        // int a = sc.nextInt();
        // String str = sc.nextLine();
        // double d= sc.nextDouble();
        // System.out.println(a+" "+str+" "+d);
        File fi = new File("sample.txt");
        
        if(fi.exists()){
            try {
                BufferedReader read = new BufferedReader(new FileReader("sample.txt"));
                String ln;
                while((ln = read.readLine())!=null)
                    System.out.print(ln);
                
            } catch (IOException e) {
                // TODO: handle exception
                System.err.println(e.getMessage());
            }
            // finally{
            //     try{
            //         read.close();
            //     }catch(IOException e){}
            // }
        }
            
        else
        System.out.println("file not exist");
    }
}
// _____
// |exit|
// ______