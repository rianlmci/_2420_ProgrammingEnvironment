package ceRecursion;

public class Recursion {
    public static void hailstorm(int seed) throws IllegalArgumentException{
        if(seed <= 0){
            throw new IllegalArgumentException("Number must be bigger than zero!");
        }

        System.out.print(seed + " ");

        //break out cases
        if(seed == 1){
            System.out.print("\n");
        }
        else if(seed % 2 == 0){
            seed = (seed / 2);
            hailstorm(seed);
        }
        else {
            seed = ((3 * seed) + 1);
            hailstorm(seed);
        }
    }
    public static void main(String[] args){
        hailstorm(3);
        hailstorm(12);
        hailstorm(23);
    }
}
