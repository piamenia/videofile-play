package kr.co.hoon.a180607video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    // 재생할 비디오의 url
    final String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    // 비디오뷰
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.play).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // 비디오 재생위치 변경
                videoView.seekTo(0);
                // 비디오 재생
                videoView.start();
            }
        });

        // 비디오뷰 가져오기
        videoView = (VideoView)findViewById(R.id.videoView);
        // 미디어 컨트롤러 설정
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        // 비디오 경로
        videoView.setVideoURI(Uri.parse(VIDEO_URL));
        // 포커스 설정
        videoView.requestFocus();

        // 재생준비가 완료됐을 때 호출되는 메소드
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "재생준비가 완료됐습니다.", Toast.LENGTH_LONG).show();
            }
        });
        // 재생이 완료됐을 때 호출되는 메소드
        // 보통 비디오파일이 여러개일 때 다음 파일을 재생하거나, 재생완료를 알려줌
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "재생이 끝났습니다.", Toast.LENGTH_LONG).show();
            }
        });

        // max vol 버튼
        findViewById(R.id.vol).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    // 액티비티가 중지되거나 종료됐다가 다시 화면에 출력될 때 호출되는 메소드
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "동영상 준비중", Toast.LENGTH_LONG).show();
    }
}
