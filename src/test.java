public class test {
    public static void main(String[] args) {


        double angel = Math.toDegrees(Math.atan2(0,1));

        System.out.println(angel);
        System.out.println((360+angel)%360);
    }
}
