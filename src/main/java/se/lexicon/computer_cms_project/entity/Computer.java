package se.lexicon.computer_cms_project.entity;

import javax.persistence.*;
import java.util.Objects;


public class Computer {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int computerId;
    private String brand;
    private String model;
    private String osSerialKey;
    @Column(unique = true)
    private String serialNumber;
    private String cpuSpeed;
    private String gpuCard;
    private String ramSize;
    private String hddSize;
    private String screenResolution;
    private String supportNote;
    private String otherNotes;
    private boolean activeStatus;
    private ComputerWhereabout computerWhereabout;

    //Constructor 1
    public Computer(int id,
                    String brand, String model, String osSerialKey,
                    String serialNumber, String cpuSpeed, String gpuCard,
                    String ramSize, String hddSize, String screenResolution,
                    String supportNote, String otherNotes, boolean activeStatus,
                    ComputerWhereabout computerWhereabout) {
        this.computerId = id;
        this.setBrand(brand);
        this.setModel(model);
        this.setOsSerialKey(osSerialKey);
        this.setSerialNumber(serialNumber);
        this.setCpuSpeed(cpuSpeed);
        this.setGpuCard(gpuCard);
        this.setRamSize(ramSize);
        this.setHddSize(hddSize);
        this.setScreenResolution(screenResolution);
        this.setSupportNote(supportNote);
        this.setOtherNotes(otherNotes);
        this.setActiveStatus(activeStatus);
        this.setComputerWhereabout(computerWhereabout);
    }
    //Constructor 2
    public Computer(String brand, String model, String osSerialKey,
                    String serialNumber, String cpuSpeed, String gpuCard,
                    String ramSize, String hddSize, String screenResolution,
                    String supportNote, String otherNotes, boolean activeStatus,
                    ComputerWhereabout computerWhereabout) {
        this(0, brand, model, osSerialKey, serialNumber, cpuSpeed, gpuCard, ramSize, hddSize, screenResolution, supportNote, otherNotes, activeStatus, computerWhereabout);
    }

    //Empty Constructor
    public Computer() {}


    //Getters & Setters
    public int getId() { return computerId; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getOsSerialKey() { return osSerialKey; }
    public void setOsSerialKey(String osSerialKey) { this.osSerialKey = osSerialKey; }
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public String getCpuSpeed() { return cpuSpeed; }
    public void setCpuSpeed(String cpuSpeed) { this.cpuSpeed = cpuSpeed; }
    public String getGpuCard() { return gpuCard; }
    public void setGpuCard(String gpuCard) { this.gpuCard = gpuCard; }
    public String getRamSize() { return ramSize; }
    public void setRamSize(String ramSize) { this.ramSize = ramSize; }
    public String getHddSize() { return hddSize; }
    public void setHddSize(String hddSize) { this.hddSize = hddSize; }
    public String getScreenResolution() { return screenResolution; }
    public void setScreenResolution(String screenResolution) { this.screenResolution = screenResolution; }
    public String getSupportNote() { return supportNote; }
    public void setSupportNote(String supportNote) { this.supportNote = supportNote; }
    public String getOtherNotes() { return otherNotes; }
    public void setOtherNotes(String otherNotes) { this.otherNotes = otherNotes; }
    public boolean isActiveStatus() { return activeStatus; }
    public void setActiveStatus(boolean activeStatus) { this.activeStatus = activeStatus; }
    public ComputerWhereabout getComputerWhereabout() { return computerWhereabout; }
    public void setComputerWhereabout(ComputerWhereabout computerWhereabout) { this.computerWhereabout = computerWhereabout; }

    //Hashcode & Equals Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return computerId == computer.computerId &&
                activeStatus == computer.activeStatus &&
                brand.equals(computer.brand) &&
                model.equals(computer.model) &&
                osSerialKey.equals(computer.osSerialKey) &&
                serialNumber.equals(computer.serialNumber) &&
                cpuSpeed.equals(computer.cpuSpeed) &&
                gpuCard.equals(computer.gpuCard) &&
                ramSize.equals(computer.ramSize) &&
                hddSize.equals(computer.hddSize) &&
                screenResolution.equals(computer.screenResolution) &&
                supportNote.equals(computer.supportNote) &&
                otherNotes.equals(computer.otherNotes) &&
                computerWhereabout.equals(computer.computerWhereabout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(computerId, brand, model, osSerialKey, serialNumber, cpuSpeed, gpuCard, ramSize,
                hddSize, screenResolution, supportNote, otherNotes, activeStatus, computerWhereabout);
    }

    //toString Override

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + computerId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", osSerialKey='" + osSerialKey + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", cpuSpeed='" + cpuSpeed + '\'' +
                ", gpuCard='" + gpuCard + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", hddSize='" + hddSize + '\'' +
                ", screenResolution='" + screenResolution + '\'' +
                ", supportNote='" + supportNote + '\'' +
                ", otherNotes='" + otherNotes + '\'' +
                ", activeStatus=" + activeStatus +
                ", computerWhereAbout=" + computerWhereabout +
                '}';
    }
}
