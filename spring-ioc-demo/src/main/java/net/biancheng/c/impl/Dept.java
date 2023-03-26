package net.biancheng.c.impl;

public class Dept {
    private String deptNo;
    //部门名称
    private String deptName;
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    @Override
    public String toString() {
        return "Dept{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }

}
