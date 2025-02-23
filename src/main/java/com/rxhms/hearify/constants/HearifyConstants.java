package com.rxhms.hearify.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HearifyConstants {
  public static final String INTERNAL_SERVER_ERROR = "Internal server error";
  public static final int RANDOM_SIZE = 3;
  public static final String DEFAULT_ALBUM_COVER = """
          https://i.ibb.co/fYBxTvvC/hearify.png"""; // hearify logo
}
