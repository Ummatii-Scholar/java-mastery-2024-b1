/**
 * basic
 */
public class basic {


    // int a1 = 1;
    public static void main(String[] args) {
        sub3 va = new sub3();
        va.display();
        //main method is the entry point of a program
        // System.out.print("hai\n");
        // System.out.println("hai");
        // end of function

        //variables - container values(character word numerical one)
        //datatype varaiablename;
        // varname=new datatype(4);
        //primitive ,non primitive 
        //primitive - int(2^32 -2^31-1 - 2^31-1), float(32 bit ), char, byte(-128to 127 2^8), short(16 bit rep of integer 2^16) ,long(64 bit rep), double,(64bit rep) boolean - basic datatype eg 1 a 1.23 true false
        //non primitive - String, Array 
        //  int age = 22;  
        //  System.out.println(age);
        //  float avg = (float)2.54;
        //  System.out.println(avg);
        //  char ch = 's';
        //  String str = "String";
        //  System.out.println(str)
        //  int[] a = new int[4];
        //  float[] b = new float[3];
        // scope local static nonstatic {} 
        // int a =1;
        // System.out.println(a);


        // mathematical operator  - + * / % 
        // assignment operator = -= += *= /= %=
        int a = 5;
        int  b =10;
        // System.out.printf("%.0f %.0f %.0f %.1f %.0f", a+b, a-b, a*b, a/b, a%b);// 15 -5 50 0.5 5 //15 -5 50 0.5 5
        int c = 10;// 11 10 50
        // System.out.printf("%d %d %d %d", c+=1, c-=1, c*=5, c/=5);// 11 10 50 10 // 11 10 50 10
        // < > == != <= >=
        // System.out.println(a>b);
        // logical operator && || !
        // System.out.println(true && true);
        // System.out.println(false && true);
        // System.out.println(true && false);
        // System.out.println(false && false);

        // System.out.println(true || true);
        // System.out.println(false || true);
        // System.out.println(true || false);
        // System.out.println(false || false);

        // System.out.println(!true);
        // System.out.println(!false);
        // incre decre ++ -- 

        // System.out.println(++a +" "+ --a);//6 5
        
        // condition? true:false 
        // int small = a<b ? a:b;
        // System.out.println(small);
        
        // bitwise & | ^ ~ << >>
        // 6 3 110 011 010 111 101 001 1100 0 .... 011 2 7 5 1 12 3
        // System.out.printf("%d %d %d %d %d %d", 10|4, 10&4, 6^3, ~6, 6<<1, 6>>1);
        // 
        int plate =3;
        // while(true){
        //     if(plate == 0){
        //         System.out.println("get me some dosa");
        //         break;
        //     } 
        //     else if (plate ==1) {
        //         System.out.println("enough");
        //     }
        //     else{
        //         System.out.println("Eating");
        //     }
        //     plate--;
        // }
        // int n = 8;
        // switch (n%2) {
        //     case 0:
        //         System.out.println("even");
        //         break;
        //     case 1:
        //         System.out.println("odd");
        //         break;
        //     default:
        //         break;
        // }
        // loop for while do while
        int n=6;
        int i =7;
        // while(true){
        //     System.out.println(i);
        //     if(i==n)
        //         break;
        //     i++;
        // }
        // while(i!=5){
        //     System.out.println(i);
        //     i++;
        // }
        // i=0;
        // do{
        //     i++;
        //     System.out.println(i);
            
        // }while (i!=5);
        // System.out.println("filled");
        // sum(9, 9);
        // System.out.println(add());
    //     for(int j =0; j<4; j++){
    //     System.out.println(j);
    // }
    } 
    //default public private protected
    public static void sum(int a, int b){
        System.out.println("The sum is "+(a+b));
    }
    static int add(){
        return 7+6;
    }
    // cando
    // for(init; condition; modify){
    //     code;
    // }
}
