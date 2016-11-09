
package serverpack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the serverpack package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteMovie_QNAME = new QName("http://serverpack/", "DeleteMovie");
    private final static QName _DeleteMovieResponse_QNAME = new QName("http://serverpack/", "DeleteMovieResponse");
    private final static QName _Edit_QNAME = new QName("http://serverpack/", "Edit");
    private final static QName _EditResponse_QNAME = new QName("http://serverpack/", "EditResponse");
    private final static QName _Exception_QNAME = new QName("http://serverpack/", "Exception");
    private final static QName _Save_QNAME = new QName("http://serverpack/", "Save");
    private final static QName _SaveResponse_QNAME = new QName("http://serverpack/", "SaveResponse");
    private final static QName _AddMovie_QNAME = new QName("http://serverpack/", "addMovie");
    private final static QName _AddMovieResponse_QNAME = new QName("http://serverpack/", "addMovieResponse");
    private final static QName _Checklogin_QNAME = new QName("http://serverpack/", "checklogin");
    private final static QName _CheckloginResponse_QNAME = new QName("http://serverpack/", "checkloginResponse");
    private final static QName _Getsqr_QNAME = new QName("http://serverpack/", "getsqr");
    private final static QName _GetsqrResponse_QNAME = new QName("http://serverpack/", "getsqrResponse");
    private final static QName _Movie_QNAME = new QName("http://serverpack/", "movie");
    private final static QName _MovieResponse_QNAME = new QName("http://serverpack/", "movieResponse");
    private final static QName _SerchbyID_QNAME = new QName("http://serverpack/", "serchbyID");
    private final static QName _SerchbyIDResponse_QNAME = new QName("http://serverpack/", "serchbyIDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: serverpack
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteMovie }
     * 
     */
    public DeleteMovie createDeleteMovie() {
        return new DeleteMovie();
    }

    /**
     * Create an instance of {@link DeleteMovieResponse }
     * 
     */
    public DeleteMovieResponse createDeleteMovieResponse() {
        return new DeleteMovieResponse();
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link EditResponse }
     * 
     */
    public EditResponse createEditResponse() {
        return new EditResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Save }
     * 
     */
    public Save createSave() {
        return new Save();
    }

    /**
     * Create an instance of {@link SaveResponse }
     * 
     */
    public SaveResponse createSaveResponse() {
        return new SaveResponse();
    }

    /**
     * Create an instance of {@link AddMovie }
     * 
     */
    public AddMovie createAddMovie() {
        return new AddMovie();
    }

    /**
     * Create an instance of {@link AddMovieResponse }
     * 
     */
    public AddMovieResponse createAddMovieResponse() {
        return new AddMovieResponse();
    }

    /**
     * Create an instance of {@link Checklogin }
     * 
     */
    public Checklogin createChecklogin() {
        return new Checklogin();
    }

    /**
     * Create an instance of {@link CheckloginResponse }
     * 
     */
    public CheckloginResponse createCheckloginResponse() {
        return new CheckloginResponse();
    }

    /**
     * Create an instance of {@link Getsqr }
     * 
     */
    public Getsqr createGetsqr() {
        return new Getsqr();
    }

    /**
     * Create an instance of {@link GetsqrResponse }
     * 
     */
    public GetsqrResponse createGetsqrResponse() {
        return new GetsqrResponse();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link MovieResponse }
     * 
     */
    public MovieResponse createMovieResponse() {
        return new MovieResponse();
    }

    /**
     * Create an instance of {@link SerchbyID }
     * 
     */
    public SerchbyID createSerchbyID() {
        return new SerchbyID();
    }

    /**
     * Create an instance of {@link SerchbyIDResponse }
     * 
     */
    public SerchbyIDResponse createSerchbyIDResponse() {
        return new SerchbyIDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "DeleteMovie")
    public JAXBElement<DeleteMovie> createDeleteMovie(DeleteMovie value) {
        return new JAXBElement<DeleteMovie>(_DeleteMovie_QNAME, DeleteMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "DeleteMovieResponse")
    public JAXBElement<DeleteMovieResponse> createDeleteMovieResponse(DeleteMovieResponse value) {
        return new JAXBElement<DeleteMovieResponse>(_DeleteMovieResponse_QNAME, DeleteMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "Edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "EditResponse")
    public JAXBElement<EditResponse> createEditResponse(EditResponse value) {
        return new JAXBElement<EditResponse>(_EditResponse_QNAME, EditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Save }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "Save")
    public JAXBElement<Save> createSave(Save value) {
        return new JAXBElement<Save>(_Save_QNAME, Save.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "SaveResponse")
    public JAXBElement<SaveResponse> createSaveResponse(SaveResponse value) {
        return new JAXBElement<SaveResponse>(_SaveResponse_QNAME, SaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "addMovie")
    public JAXBElement<AddMovie> createAddMovie(AddMovie value) {
        return new JAXBElement<AddMovie>(_AddMovie_QNAME, AddMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "addMovieResponse")
    public JAXBElement<AddMovieResponse> createAddMovieResponse(AddMovieResponse value) {
        return new JAXBElement<AddMovieResponse>(_AddMovieResponse_QNAME, AddMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Checklogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "checklogin")
    public JAXBElement<Checklogin> createChecklogin(Checklogin value) {
        return new JAXBElement<Checklogin>(_Checklogin_QNAME, Checklogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckloginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "checkloginResponse")
    public JAXBElement<CheckloginResponse> createCheckloginResponse(CheckloginResponse value) {
        return new JAXBElement<CheckloginResponse>(_CheckloginResponse_QNAME, CheckloginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getsqr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "getsqr")
    public JAXBElement<Getsqr> createGetsqr(Getsqr value) {
        return new JAXBElement<Getsqr>(_Getsqr_QNAME, Getsqr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetsqrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "getsqrResponse")
    public JAXBElement<GetsqrResponse> createGetsqrResponse(GetsqrResponse value) {
        return new JAXBElement<GetsqrResponse>(_GetsqrResponse_QNAME, GetsqrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "movie")
    public JAXBElement<Movie> createMovie(Movie value) {
        return new JAXBElement<Movie>(_Movie_QNAME, Movie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "movieResponse")
    public JAXBElement<MovieResponse> createMovieResponse(MovieResponse value) {
        return new JAXBElement<MovieResponse>(_MovieResponse_QNAME, MovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerchbyID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "serchbyID")
    public JAXBElement<SerchbyID> createSerchbyID(SerchbyID value) {
        return new JAXBElement<SerchbyID>(_SerchbyID_QNAME, SerchbyID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerchbyIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serverpack/", name = "serchbyIDResponse")
    public JAXBElement<SerchbyIDResponse> createSerchbyIDResponse(SerchbyIDResponse value) {
        return new JAXBElement<SerchbyIDResponse>(_SerchbyIDResponse_QNAME, SerchbyIDResponse.class, null, value);
    }

}
