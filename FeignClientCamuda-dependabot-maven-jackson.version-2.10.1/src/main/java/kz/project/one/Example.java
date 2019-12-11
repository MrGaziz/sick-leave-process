package kz.project.one;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "birthday",
        "email",
        "teamlead",
        "fullName",
        "aboutMyself",
        "direction",
        "id",
        "hobby",
        "status",
        "projects",
        "phone",
        "gender"
})
@Data
@ToString
public class Example {

    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("email")
    private String email;
    @JsonProperty("teamlead")
    private String teamlead;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("aboutMyself")
    private String aboutMyself;
    @JsonProperty("direction")
    private Direction direction;
    @JsonProperty("id")
    private String id;
    @JsonProperty("hobby")
    private List<String> hobby = null;
    @JsonProperty("status")
    private String status;
    @JsonProperty("projects")
    private List<Project> projects = null;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("gender")
    private String gender;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("birthday")
    public String getBirthday() {
        return birthday;
    }

    @JsonProperty("birthday")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("teamlead")
    public String getTeamlead() {
        return teamlead;
    }

    @JsonProperty("teamlead")
    public void setTeamlead(String teamlead) {
        this.teamlead = teamlead;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("aboutMyself")
    public String getAboutMyself() {
        return aboutMyself;
    }

    @JsonProperty("aboutMyself")
    public void setAboutMyself(String aboutMyself) {
        this.aboutMyself = aboutMyself;
    }

    @JsonProperty("direction")
    public Direction getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("hobby")
    public List<String> getHobby() {
        return hobby;
    }

    @JsonProperty("hobby")
    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("projects")
    public List<Project> getProjects() {
        return projects;
    }

    @JsonProperty("projects")
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}