package allaboutecm.model;

import com.google.common.collect.Sets;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * An artist that has been featured in (at least) one ECM record.
 *
 * See {@https://www.ecmrecords.com/artists/1435045745}
 */
public class Musician extends Entity {
    private String name;

    private URL musicianUrl;

    private Set<Album> albums;

    public Musician(String name) {
        notNull(name);
        notBlank(name);

        this.name = name;
        this.musicianUrl = null;

        albums = Sets.newLinkedHashSet();
    }

    public String getName() {
        return name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician that = (Musician) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public URL getMusicianUrl() {
        return musicianUrl;
    }

    public void setMusicianUrl(URL musicianUrl) {
        this.musicianUrl = musicianUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean validName(String inputName){
        if(inputName.trim().indexOf(" ")!=-1) {
            return true;
        } else{
            return false;
        }
    }

    public boolean isValidURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            return true;
        }
        catch (MalformedURLException e) {
            return false;
        }
    }
}
