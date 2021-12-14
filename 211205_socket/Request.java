// toDo: 
//      1. separare risorsa da parametri

import java.util.HashMap;

public class Request {
    public String method;
    public String uri;
    public HashMap<String, String[]> headers;
    public String body;

    public Request(String method, String uri, HashMap<String, String[]> headers) {
        this.method = method;
        this.uri = uri;
        this.headers = headers;
        this.body = null;
    }

    public Request(String method, String uri, HashMap<String, String[]> headers, String body) {
        this.method = method;
        this.uri = uri;
        this.headers = headers;
        this.body = body;
    }

    public boolean hasBody() {
        if (this.body != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        String report = this.method + " " + this.uri + "\n";
        for (String key : headers.keySet()) {
            report = report + key + ": ";
            {
                int i = 0;
                for (String[] values = headers.get(key); i < values.length; i++) {
                    report = report + values[i];
                    if (i < values.length - 1) {
                        report = report + ",";
                    } else {
                        report = report + "\n";
                    }
                }
            }
        }
        if (this.hasBody())
            report = report + "\n" + this.body;

        return report;
    }
}