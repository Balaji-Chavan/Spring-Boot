package com.cjss.Task2.model;

import java.util.List;

public class Staff {
    private String staffId;
    private String staffName;
    private String staffEmail;
    private List<Subjects> lsub;
    public Staff(String staffId, String staffName, String staffEmail, List<Subjects> lsub) {
        super();
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.lsub = lsub;
    }
    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getStaffEmail() {
        return staffEmail;
    }
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
    public List<Subjects> getLsub() {
        return lsub;
    }
    public void setLsub(List<Subjects> lsub) {
        this.lsub = lsub;
    }
    @Override
    public String toString() {
        return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffEmail=" + staffEmail + ", lsub=" + lsub
                + "]";
    }


}
