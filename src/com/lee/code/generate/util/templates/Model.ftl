package ${package_name}.model;
import com.evada.inno.common.domain.BaseModel;
import com.evada.inno.common.listener.ICreateListenable;
import com.evada.inno.common.listener.IDeleteListenable;
import com.evada.inno.common.listener.IModifyListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
@Entity
@Table(name="${table_name_small}")
@Where(clause = "status > '0'")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class ${table_name} extends BaseModel implements ICreateListenable,IModifyListenable,IDeleteListenable {

    <#if model_column?exists>
        <#list model_column as model>
    /**
    *${model.columnComment!}
    */
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    @Column(name = "${model.columnName}",columnDefinition = "VARCHAR")
    private String ${model.changeColumnName?uncap_first};

    </#if>
    
    <#if model.columnType = 'INT'>
    @Column(name = "${model.columnName}",columnDefinition = "INT")
    private Integer ${model.changeColumnName?uncap_first};

    </#if>
    
    <#if model.columnType = 'DECIMAL'>
    @Column(name = "${model.columnName}",columnDefinition = "DECIMAL")
    private Double ${model.changeColumnName?uncap_first};

    </#if>
    
    <#if (model.columnType = 'TIMESTAMP' || model.columnType = 'DATETIME')>
    @Column(name = "${model.columnName}",columnDefinition = "TIMESTAMP")
    private Date ${model.changeColumnName?uncap_first};

    </#if>
        </#list>
    </#if>

<#if model_column?exists>
<#list model_column as model>
<#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

</#if>

<#if model.columnType = 'INT'>
    public Integer get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Integer ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

</#if>

<#if model.columnType = 'DECIMAL'>
    public Double get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Double ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

</#if>

<#if (model.columnType = 'TIMESTAMP' || model.columnType = 'DATETIME')>
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

</#if>
</#list>
</#if>

}