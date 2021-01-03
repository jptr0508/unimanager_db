package pt.iade.unimanager_db.models.id;

import java.io.Serializable;

public class PlanId implements Serializable{
    private static final long serialVersionUID=5L;

    private int unitId;
    private int courseId;

    public PlanId(){}

    @Override
    public boolean equals(Object obj){
        return obj!=null && obj.getClass() == PlanId.class && 
        ((PlanId)obj).courseId == courseId &&
        ((PlanId)obj).unitId == unitId;
    }

	public PlanId(int unitId, int courseId) {
		this.unitId = unitId;
		this.courseId = courseId;
    }
    
    public int getUnitId(){
        return unitId;
    }

    public void setUnitId(){
        this.unitId = unitId;
    }

    public int getCourseId(){
        return courseId;
    }

    public void setCourseId(){
        this.courseId = courseId;
    }
}
