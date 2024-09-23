package Day_1;
public class cando {
    public static void main(String[] args) {
        sub3 var = new sub3();
        var.display();
        var.display1();
    }
}
class sub{
    static float pi;
    static String name;
    sub(String name){
        System.out.println("sub");
    }
}
// singleinheritance
class sub2 extends sub {
    sub2(String name) {
        super(name);
        System.out.println("sub2");
    }
}
// multilevel
class sub3 implements Icando, Indo{
    sub3() {
        System.out.println("sub3");
    }
    @Override
    public void display() {
        System.out.println("hai");
    }
   @Override
   public void display1() {
       System.out.println("display1");
   } 
}
// mutiple inheritance sub sub2 sub3 sub4
// herachi inheritance sub sub1 sub2
// hybrid 
/**
 * Innercando
 */
interface Icando {
    public void display();
}
/**
 * Innercando
 */
interface Indo {

   void display1(); 
}
/*
inheritance - two wheelers -gearless -geared - honda - tvs - jawa - rolyal enfeild - scooty- x100 - x80 escooters 
*/