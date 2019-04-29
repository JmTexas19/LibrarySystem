public abstract class AbstractLoadInventory {
    private FullLibraryIF library;

    //Set Library
    public void setLibrary(FullLibraryIF library){
        this.library = library;
    }

    //Get Library
    protected FullLibraryIF getLibrary(){
        return library;
    }

    public abstract void startImport();
}
