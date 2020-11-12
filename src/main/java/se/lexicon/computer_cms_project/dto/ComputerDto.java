package se.lexicon.computer_cms_project.dto;

import se.lexicon.computer_cms_project.entity.ComputerWhereabout;
import se.lexicon.computer_cms_project.entity.Note;

public class ComputerDto {
    private int computerId;
    private String computerBrand;
    private String computerModel;
    private String computerOsSerialKey;
    private String computerSerialNumber;
    private String computerCpuSpeed;
    private String computerGpuCard;
    private String computerRamSize;
    private String computerHddSize;
    private String computerScreenResolution;
    private NoteDto computerSupportNote;
    private NoteDto computerOtherNotes;
    private boolean activeStatus;
    private ComputerWhereaboutDto computerWhereabout;

    public ComputerDto(int computerId, String computerBrand, String computerModel, String computerOsSerialKey,
                       String computerSerialNumber, String computerCpuSpeed, String computerGpuCard,
                       String computerRamSize, String computerHddSize, String computerScreenResolution,
                       NoteDto computerSupportNote, NoteDto computerOtherNotes, boolean activeStatus,
                       ComputerWhereaboutDto computerWhereabout) {
        this.setComputerId(computerId);
        this.setComputerBrand(computerBrand);
        this.setComputerModel(computerModel);
        this.setComputerOsSerialKey(computerOsSerialKey);
        this.setComputerSerialNumber(computerSerialNumber);
        this.setComputerCpuSpeed(computerCpuSpeed);
        this.setComputerGpuCard(computerGpuCard);
        this.setComputerRamSize(computerRamSize);
        this.setComputerHddSize(computerHddSize);
        this.setComputerScreenResolution(computerScreenResolution);
        this.setComputerSupportNote(computerSupportNote);
        this.setComputerOtherNotes(computerOtherNotes);
        this.setActiveStatus(activeStatus);
        this.setComputerWhereabout(computerWhereabout);
    }

    public ComputerDto() {}

    public int getComputerId() { return computerId; }
    public void setComputerId(int computerId) { this.computerId = computerId; }
    public String getComputerBrand() { return computerBrand; }
    public void setComputerBrand(String computerBrand) { this.computerBrand = computerBrand; }
    public String getComputerModel() { return computerModel; }
    public void setComputerModel(String computerModel) { this.computerModel = computerModel; }
    public String getComputerOsSerialKey() { return computerOsSerialKey; }
    public void setComputerOsSerialKey(String computerOsSerialKey) { this.computerOsSerialKey = computerOsSerialKey; }
    public String getComputerSerialNumber() { return computerSerialNumber; }
    public void setComputerSerialNumber(String computerSerialNumber) { this.computerSerialNumber = computerSerialNumber; }
    public String getComputerCpuSpeed() { return computerCpuSpeed; }
    public void setComputerCpuSpeed(String computerCpuSpeed) { this.computerCpuSpeed = computerCpuSpeed; }
    public String getComputerGpuCard() { return computerGpuCard; }
    public void setComputerGpuCard(String computerGpuCard) { this.computerGpuCard = computerGpuCard; }
    public String getComputerRamSize() { return computerRamSize; }
    public void setComputerRamSize(String computerRamSize) { this.computerRamSize = computerRamSize; }
    public String getComputerHddSize() { return computerHddSize; }
    public void setComputerHddSize(String computerHddSize) { this.computerHddSize = computerHddSize; }
    public String getComputerScreenResolution() { return computerScreenResolution; }
    public void setComputerScreenResolution(String computerScreenResolution) { this.computerScreenResolution = computerScreenResolution; }
    public NoteDto getComputerSupportNote() { return computerSupportNote; }
    public void setComputerSupportNote(NoteDto computerSupportNote) { this.computerSupportNote = computerSupportNote; }
    public NoteDto getComputerOtherNotes() { return computerOtherNotes; }
    public void setComputerOtherNotes(NoteDto computerOtherNotes) { this.computerOtherNotes = computerOtherNotes; }
    public boolean isActiveStatus() { return activeStatus; }
    public void setActiveStatus(boolean activeStatus) { this.activeStatus = activeStatus; }
    public ComputerWhereaboutDto getComputerWhereabout() { return computerWhereabout; }
    public void setComputerWhereabout(ComputerWhereaboutDto computerWhereabout) { this.computerWhereabout = computerWhereabout; }
}
