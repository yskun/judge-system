package team.next.judgesystem.model;

import javax.persistence.*;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@Entity
@Table(name = "ManageState", schema = "dbo", catalog = "shamomo")
public class ManageStateEntity {
    private int id;
    private String statedeScription;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StatedeScription")
    public String getStatedeScription() {
        return statedeScription;
    }

    public void setStatedeScription(String statedeScription) {
        this.statedeScription = statedeScription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManageStateEntity that = (ManageStateEntity) o;

        if (id != that.id) return false;
        if (statedeScription != null ? !statedeScription.equals(that.statedeScription) : that.statedeScription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statedeScription != null ? statedeScription.hashCode() : 0);
        return result;
    }
}
