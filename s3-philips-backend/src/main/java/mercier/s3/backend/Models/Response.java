package mercier.s3.backend.Models;

import java.io.Serializable;

public class Response implements Serializable {
    private Object data;
    private Object error;
    private int status;
    private String statusVerbose;

    public Response() {
        this.setStatus(404);
    }

    public Response(int statusCode) {
        this.setStatus(statusCode);
    }

    public Response(int statusCode, Object data) {
        this.setStatus(statusCode);
        this.setData(data);
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return this.data;
    }

    public void setStatus(int status) {
        this.status = status;
        this.setStatusVerbose(status);
    }
    public int getStatus() {
        return this.status;
    }

    private void setStatusVerbose(int status) {
        switch(status) {
            case 200:
                this.statusVerbose = "OK";
                break;
            case 400:
                this.statusVerbose = "Bad Request";
                break;
            case 401:
                this.statusVerbose = "Not Authorized";
                break;
            case 404:
                this.statusVerbose = "Not Found";
                break;
            case 500:
                this.statusVerbose = "Internal Server Error";
                break;
        }
    }
    public String getStatusVerbose() {
        return this.statusVerbose;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}
