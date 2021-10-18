package ch.hslu.ad.exercise.e1;

public class SymmetricalNumberChecker {
    public boolean isSymmetrical(int size, int number){
        var splitted = new int[size];

        for(var i = 0; i < size; i++){
            splitted[i] = number % 10;
            number /= 10;
        }

        for(var i = 0; i < size / 2; i++){
            if(splitted[i] != splitted[size - 1 - i]){
                return false;
            }
        }

        return true;
    }

    public int getNextBiggestSymmetrical(int size, int number){
        while(!isSymmetrical(size, number)){
            number++;
        }

        return number;
    }
}
