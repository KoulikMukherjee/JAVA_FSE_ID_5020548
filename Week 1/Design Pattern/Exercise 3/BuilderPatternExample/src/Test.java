public class Test {
    public static void main(String[] args) {

        Computer computer = new Computer.ComputerBuilder()
                .setCPU("i5 12th gen")
                .setGPU("Nvidea mx350")
                .setRAM("8GB DDR4")
                .setStorage("1TB")
                .build();
        System.out.println(computer.toString());
    }
}