import os
import yt_dlp as yt

def open_sources_files(file_name):
    links = []

    with open(file_name, 'r') as reader:
        lines = reader.readlines()
        for index, line in enumerate(lines):
            links.append(line.strip())
    
    return links

def create_folder_export(path_name):

    if not os.path.exists(path_name):
        os.makedirs(path_name)

def download_link(link):
    yt_dlp.YoutubeDL()
    # yt-dlp -o "%(title)s.%(ext)s" --extract-audio -f bestaudio --audio-format m4a --embed-metadata --embed-thumbnail --convert-thumbnails jpg --ppa "ffmpeg: -c:v mjpeg -vf crop=\"'if(gt(ih,iw),iw,ih)':'if(gt(iw,ih),ih,iw)'\""  "https://www.youtube.com/watch?v=EiV1YxtbfcE"


if __name__ == "__main__" :
    export_path = "./export"
    links = open_sources_files("./sources")

    print(links)
    create_folder_export(export_path)


