package co.edu.uco.publiuco.api.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.api.response.dto.Message;

public class Response<D> {

    private List<D> data;
    private List<Message> message;

    public Response() {
        super();
    }

    public void addMessage(final Message message ) {
        if(!UtilObject.isNull(message)) {
            getMessage().add(message);
        }

    }
    public void addData(final D data ) {
        if(!UtilObject.isNull(data)) {
            getData().add(data);
        }

    }

    public List<D> getData() {
        if(UtilObject.isNull(data)) {
            this.data = new ArrayList<>();
        }
        return data;
    }

    public void setData(List<D> data) {
        this.data = UtilObject.getDefaultIfNull(data, new ArrayList<>());
    }

    public List<Message> getMessage() {
        if(UtilObject.isNull(message)) {
            this.message = new ArrayList<>();
        }
        return message;
    }

    public void setMessage(List<Message> messages) {
        this.message = UtilObject.getDefaultIfNull(messages, new ArrayList<>());
    }
}
