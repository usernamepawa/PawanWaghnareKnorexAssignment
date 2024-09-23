package com.vastparser.model;

import java.util.List;

public class VastTag {
    private String version;
    private String id;
    private String title;
    private String description;
    private Impression impression;
    private List<Creative> creatives;

    public static class Impression {
        private String id;
        private String url;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
       
    }

    public static class Creative {
        private String id;
        private List<CompanionBanner> companionBanners;
        private List<TrackingEvent> trackingEvents;
        private List<VideoClick> videoClicks;
        private List<MediaFile> mediaFiles;
        private int duration;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public List<CompanionBanner> getCompanionBanners() {
			return companionBanners;
		}
		public void setCompanionBanners(List<CompanionBanner> companionBanners) {
			this.companionBanners = companionBanners;
		}
		public List<TrackingEvent> getTrackingEvents() {
			return trackingEvents;
		}
		public void setTrackingEvents(List<TrackingEvent> trackingEvents) {
			this.trackingEvents = trackingEvents;
		}
		public List<VideoClick> getVideoClicks() {
			return videoClicks;
		}
		public void setVideoClicks(List<VideoClick> videoClicks) {
			this.videoClicks = videoClicks;
		}
		public List<MediaFile> getMediaFiles() {
			return mediaFiles;
		}
		public void setMediaFiles(List<MediaFile> mediaFiles) {
			this.mediaFiles = mediaFiles;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
       
    }

    public static class CompanionBanner {
        private String id;
        private int width;
        private int height;
        private String type;
        private String source;
        private String clickThroughUrl;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getClickThroughUrl() {
			return clickThroughUrl;
		}
		public void setClickThroughUrl(String clickThroughUrl) {
			this.clickThroughUrl = clickThroughUrl;
		}
      
    }

    public static class TrackingEvent {
        private String type;
        private String url;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
       
    }

    public static class VideoClick {
        private String id;
        private String url;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
        
    }

    public static class MediaFile {
        private String type;
        private int bitrate;
        private int width;
        private int height;
        private String source;
       
    }

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Impression getImpression() {
		return impression;
	}

	public void setImpression(Impression impression) {
		this.impression = impression;
	}

	public List<Creative> getCreatives() {
		return creatives;
	}

	public void setCreatives(List<Creative> creatives) {
		this.creatives = creatives;
	}

    
}
