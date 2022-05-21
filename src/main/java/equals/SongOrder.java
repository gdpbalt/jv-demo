package equals;

/**
 * Make possible initialization using static factory methods. See requirements in task description.
 */
public class SongOrder {
  private String singer;
  private String songName;

  private SongOrder(String singer) {
    this.singer = singer;
  }

  private SongOrder(String singer, String songName) {
    this.singer = singer;
    this.songName = songName;
  }

  public static SongOrder of(String singer) {
    return new SongOrder(singer);
  }

  public static SongOrder of(String singer, String songName) {
    return new SongOrder(singer, songName);
  }

  @Override
  public String toString() {
    if (singer != null && songName != null) {
      return String.format("Play %s song called \"%s\"", singer, songName);
    }
    if (singer != null) {
      return String.format("Play any %s song", singer);
    }
    return "You haven't chosen a singer. Please make your choice)";
  }
}
