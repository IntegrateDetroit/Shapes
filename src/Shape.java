public abstract class Shape {

    public int[] generateXPoints(){
        int[] xCoordinates = new int[numberOfSides];
        for (int i = 0; i < numberOfSides; i++){
            double angle = 2 * i * Math.PI / numberOfSides;
            xCoordinates[i] = (int) (center + radius * Math.cos(angle));

            System.out.println(xCoordinates[i]);
        }
        return xCoordinates;
    }


    public int[] generateYPoints(){
        int[] yCoordinates = new int[numberOfSides];
        for (int i = 0; i < numberOfSides; i++){

            double angle = 2 * i * Math.PI / numberOfSides;
            yCoordinates[i] = (int) (center + radius * Math.sin(angle));
            System.out.println(yCoordinates[i]);

        }
        return yCoordinates;
    }
}

