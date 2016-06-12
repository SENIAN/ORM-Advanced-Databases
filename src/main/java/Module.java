import lombok.Data;

import java.sql.Date;

/**
 * Created by Mohammed on 6/11/2016.
 */

@Data
public class Module {

    public String ModuleCode;
    public Date invoerdatum;
    public Date einddatum;

    public Module(String ModuleCode, Date invoerdatum,Date einddatum) {
        this.ModuleCode = ModuleCode;
        this.invoerdatum = invoerdatum;
        this.einddatum = einddatum;
    }
}
