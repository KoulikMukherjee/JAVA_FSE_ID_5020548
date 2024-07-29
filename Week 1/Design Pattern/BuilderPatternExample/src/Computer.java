public class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private String GPU;

    private Computer(ComputerBuilder builder){
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GPU = builder.GPU;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + this.CPU + '\'' +
                ", RAM='" + this.RAM + '\'' +
                ", Storage='" + this.Storage + '\'' +
                ", GPU='" + this.GPU + '\'' +
                '}';
    }

    public String getCPU() {
        return this.CPU;
    }
    public String getRAM() {
        return this.RAM;
    }

    public String getStorage() {
        return this.Storage;
    }

    public String getGPU() {
        return this.GPU;
    }

    static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private String Storage;
        private String GPU;

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.Storage = storage;
            return this;
        }

        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Computer build() {
            Computer computer = new Computer(this);
            return computer;
        }
    }
}
