package extras;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import java.net.URI;
import java.net.URISyntaxException;

// Code example from http://code.google.com/p/rest-client/issues/detail?id=147
// Adds entity (aka body) support to deletes
class EntityEnclosingDelete extends HttpEntityEnclosingRequestBase {

    public EntityEnclosingDelete(){
    }

    public EntityEnclosingDelete(String uri) throws URISyntaxException{
      this(new URI(uri));
    }

    public EntityEnclosingDelete(URI uri){
      setURI(uri);
    }

    public String getMethod() {
        return "DELETE";
    }

}