package model;

public enum VideoGameSystem {

  PS4("Playstation 4", "2013", "Sony"), NSW("Switch", "2017", "Nintendo");

  private final String title;
  private final String publishingYear;
  private final String maker;

  VideoGameSystem(String title, String publishingYear, String maker) {
    this.title = title;
    this.publishingYear = publishingYear;
    this.maker = maker;
  }

  public String maker() {
    return maker;
  }

  public String publishingYear() {
    return publishingYear;
  }

  public String title() {
    return title;
  }

}
