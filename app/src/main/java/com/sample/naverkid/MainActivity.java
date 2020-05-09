package com.sample.naverkid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.PolylineOverlay;
import com.naver.maps.map.util.FusedLocationSource;
import com.sample.naverkid.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 1000;//요청권한 코드
    private FusedLocationSource locationSource;// Google Play 서비스의 Fused Location Provider를 사용하는 LocationSource 구현체.
    private static final List<LatLng> COORDS_1 = Arrays.asList(//좌표열을 배열로 나열을 해줍니다.
            new LatLng(37.5594084, 126.9745830), //해당위치 위도와 경로를 나타내는 클래스
            new LatLng(37.5599980, 126.9748245),
            new LatLng(37.5601083, 126.9748951),
            new LatLng(37.5601980, 126.9749873),
            new LatLng(37.5601998, 126.9749896),
            new LatLng(37.5602478, 126.9750492),
            new LatLng(37.5603158, 126.9751371),
            new LatLng(37.5604241, 126.9753616),
            new LatLng(37.5604853, 126.9755401),
            new LatLng(37.5605225, 126.9756157),
            new LatLng(37.5605353, 126.9756405),
            new LatLng(37.5605652, 126.9756924),
            new LatLng(37.5606143, 126.9757679),
            new LatLng(37.5606903, 126.9758432),
            new LatLng(37.5608510, 126.9758919),
            new LatLng(37.5611353, 126.9759964),
            new LatLng(37.5611949, 126.9760186),
            new LatLng(37.5612383, 126.9760364),
            new LatLng(37.5615796, 126.9761721),
            new LatLng(37.5619326, 126.9763123),
            new LatLng(37.5621502, 126.9763991),
            new LatLng(37.5622776, 126.9764492),
            new LatLng(37.5624374, 126.9765137),
            new LatLng(37.5630911, 126.9767753),
            new LatLng(37.5631345, 126.9767931),
            new LatLng(37.5635163, 126.9769240),
            new LatLng(37.5635506, 126.9769351),
            new LatLng(37.5638061, 126.9770239),
            new LatLng(37.5639153, 126.9770605),
            new LatLng(37.5639577, 126.9770749),
            new LatLng(37.5640074, 126.9770927),
            new LatLng(37.5644783, 126.9771755),
            new LatLng(37.5649229, 126.9772482),
            new LatLng(37.5650330, 126.9772667),
            new LatLng(37.5652152, 126.9772971),
            new LatLng(37.5654569, 126.9773170),
            new LatLng(37.5655173, 126.9773222),
            new LatLng(37.5656534, 126.9773258),
            new LatLng(37.5660418, 126.9773004),
            new LatLng(37.5661985, 126.9772914),
            new LatLng(37.5664663, 126.9772952),
            new LatLng(37.5668827, 126.9773047),
            new LatLng(37.5669467, 126.9773054),
            new LatLng(37.5670567, 126.9773080),
            new LatLng(37.5671360, 126.9773097),
            new LatLng(37.5671910, 126.9773116),
            new LatLng(37.5672785, 126.9773122),
            new LatLng(37.5674668, 126.9773120),
            new LatLng(37.5677264, 126.9773124),
            new LatLng(37.5680410, 126.9773068),
            new LatLng(37.5689242, 126.9772871),
            new LatLng(37.5692829, 126.9772698),
            new LatLng(37.5693829, 126.9772669),
            new LatLng(37.5696659, 126.9772615),
            new LatLng(37.5697524, 126.9772575),
            new LatLng(37.5698659, 126.9772499),
            new LatLng(37.5699671, 126.9773070),
            new LatLng(37.5700151, 126.9773395),
            new LatLng(37.5700748, 126.9773866),
            new LatLng(37.5701164, 126.9774373),
            new LatLng(37.5701903, 126.9776225),
            new LatLng(37.5701905, 126.9776723),
            new LatLng(37.5701897, 126.9777006),
            new LatLng(37.5701869, 126.9784990),
            new LatLng(37.5701813, 126.9788591),
            new LatLng(37.5701770, 126.9791139),
            new LatLng(37.5701741, 126.9792702),
            new LatLng(37.5701743, 126.9793098),
            new LatLng(37.5701752, 126.9795182),
            new LatLng(37.5701761, 126.9799315),
            new LatLng(37.5701775, 126.9800380),
            new LatLng(37.5701800, 126.9804048),
            new LatLng(37.5701832, 126.9809189),
            new LatLng(37.5701845, 126.9810197),
            new LatLng(37.5701862, 126.9811986),
            new LatLng(37.5701882, 126.9814375),
            new LatLng(37.5701955, 126.9820897),
            new LatLng(37.5701996, 126.9821860));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();//액션바
        if (actionBar != null) {//액션바가 아닐 경우
            actionBar.setDisplayHomeAsUpEnabled(true);// 최상위 레벨 또는 첫 페이지로 돌아가지 않고 UI에서 단일 레벨만큼 되돌아오면 이를 true로 설정하였습니다.
            actionBar.setDisplayShowHomeEnabled(true);// 포함여부를 설
        }
        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
// 지도를 출력하는 프래그먼트 클래스
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this); //비동기로 네이버 객체를 얻어 옵니다.
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        locationSource = new FusedLocationSource(this, ACCESS_LOCATION_PERMISSION_REQUEST_CODE);
        naverMap.setLocationSource(locationSource);
        //제스처 사용, 컨트롤 노출 등 사용자 인터페이스와 관련된 설정을 관리하는 클래스.
        UiSettings uiSettings = naverMap.getUiSettings();//Uisettings 의 객체를 반환합니다.
        uiSettings.setLocationButtonEnabled(true);

        int width = getResources().getDimensionPixelSize(R.dimen.overlay_line_width);//폴리라인 넓이
        int patternInterval = getResources().getDimensionPixelSize(R.dimen.overlay_pattern_interval);//속성을 사용하면 패턴 이미지 간 간격을 지정할 수 있습니다.
        PolylineOverlay polylineOverlay1 = new PolylineOverlay();// 폴리라인 오베러이 객체
        polylineOverlay1.setWidth(width);
        polylineOverlay1.setCoords(COORDS_1);//좌표열
        polylineOverlay1.setColor(ResourcesCompat.getColor(getResources(), R.color.primary, getTheme()));//폴리라인 오버레이 색깔
        polylineOverlay1.setMap(naverMap);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case ACCESS_LOCATION_PERMISSION_REQUEST_CODE: // 접근허가 요청
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);
                return;
        }
    }
}
