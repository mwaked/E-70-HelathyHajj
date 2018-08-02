package com.mwtraking.beinmedia.hajjhealthy.ui.fragments;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.mwtraking.beinmedia.hajjhealthy.R;
import com.mwtraking.beinmedia.hajjhealthy.base.BaseFragment;
import com.mwtraking.beinmedia.hajjhealthy.models.TipsModel;
import com.mwtraking.beinmedia.hajjhealthy.ui.adapters.AdvicesAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


public class GeneralAdvicesFragment extends BaseFragment {

    @BindView(R.id.rvRecycle)
    RecyclerView recyclerView ;

    LinearLayoutManager linearLayoutManager ;
    AdvicesAdapter advicesAdapter ;
    List<TipsModel> tipsModels = new ArrayList<>();

    public static GeneralAdvicesFragment newInstance() {
        return new GeneralAdvicesFragment();
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_general_advices;
    }

    @Override
    protected void initializeComponents(View view) {
        initAdapter();
    }


    private void initAdapter() {

        tipsModels.clear();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        advicesAdapter = new AdvicesAdapter(getActivity() , tipsModels , R.layout.recycle_incoming_message);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(advicesAdapter);

        tipsModels.add(new TipsModel("Before You Travel" , "Photocopy of all your official documents. Make extra copies of passports and photos.\n" +
                "Keep both your national currency as well as Saudi Riyals in your wallet.\n" +
                "Have your agent check in for all the bookings, hotels, foods, agreements beforehand.\n" +
                "Ensure to pay all your dues. Also, pre-pay your monthly bills so you don’t fall behind simply because you’ll be out of the country."));

        tipsModels.add(new TipsModel("Educate Yourself and Remain with the Learned" , "Have the right mentality, otherwise you would find it very difficult to cope. Take one thing at a time, have the intention to please your Lord in the best way possible, and go with an open mind.\n" +
                "Gain complete and authentic knowledge about each and every aspect of Hajj.\n" +
                "Re-learn the basics of Islam: Those going for Hajj should make sure that they are performing Wudhu and Salah and perfectly.\n" +
                "Familiarize yourself with the Hajj plan; don’t depend on the Imam to guide you on every little dua to recite or prayer to pray.\n" +
                "Study the Seerah of Prophet Muhammad ṣallallāhu 'alayhi wa sallam (peace and blessings of Allāh be upon him) and Prophet Ibrahim [as] before you go.\n" +
                "Read the book “Getting the Best Out Of Hajj” by Abu Muneer Ismail Davids. He guides very well along every step – both before and during Hajj.\n" +
                "Be careful not to be involved with shirk or incorrect practices.\n" +
                "Remain with ‘ulama (scholars) who can explain the rituals correctly. Find a group that organizes daily motivational reminders & guidelines on how to practically perform the various rituals.\n" +
                "In spite of the previous tip, know your do’s and dont’s: The crowds are massive and time is tight, so even though you are with a group, you sometimes need to do things on your own or take your own initiative. The groups try their best to streamline things for the people but certain things are beyond their control. At such times, one’s own study and knowledge comes in handy and instead of going with the group; one can do a few things independently.\n" +
                "Learn common Arabic vocabulary and phrases needed during Hajj so that it eases communication. The sign-boards there are also in Arabic and it becomes difficult to understand them.\n" +
                "Tips for Productive Hajj Gear\n" +
                "What to Wear:\n" +
                "Wear comfortable, durable sandals or shoes.\n" +
                "Keep in mind that you will put your slippers in a bag when you go to Masjid al-Haram. The floor of the haram is granite and may be hard on sensitive feet. Take a pair of home slippers or anything that has some padding to ease the hardness of the floor and pain on the feet.\n" +
                "Keep a spare Ihram while in Mina in case it gets dirty.\n" +
                "Place a damp hand towel under your cap; it will keep you fresh and energized, inshaAllah!"));

        tipsModels.add(new TipsModel("What to Carry:" , "Stay light. Keep your baggage to the essentials.\n" +
                "Take empty plastic bottles with you when going to Masjid al-Haram so you can fill up Zamzam to take back to the hotel.\n" +
                "Keep a light backpack for essential belongings you need to carry around: cash for the day, passport, small dua book, small Qur’an, packet of tissue paper, etc.\n" +
                "Keep a lightweight prayer mat with you. It can be placed on your head to protect you from the heat and also shared with others whenever you have to pray in an area without rugs. (Note: For those with weak joints or bones, carry a padded prayer mat.)\n" +
                "Carry a lightweight umbrella to shelter from the sun.\n" +
                "Take a handheld fan.\n" +
                "Take sunglasses.\n" +
                "Pack some medical face masks.\n" +
                "Take Vaseline to stop your legs from rubbing as there’ll be a lot of walking.\n" +
                "Have some basic medicines on hand for cuts and bruises (which you may develop due to much walking.)\n" +
                "Wet wipes are the life savior!\n" +
                "Women, please bring a pair of scissors so that it is easy to cut your hair at the end of Hajj.\n" +
                "Get yourself a mini Qur’an (you can also carry an Amazon Kindle for easy access to a Qur’an), a pocket-size Hajj guide, and a mini supplications book. Have your mp3 well sorted with Quran/duas/lectures; the journeys are long!\n" +
                "Keep phones which have longer battery life; you may not find place to charge your smart phone in Arafah and Muzdalifah."));
        tipsModels.add(new TipsModel("Washroom-Related Gear:" , "There are mainly only squat/floor toilets at the Hajj sites. Rather than causing yourself undue hardshi p, wasting time, and risk ending up with unclean clothing for prayer, it is best for women to wear light cotton long dresses (or jelabiyyas are perfect) underneath their outer garments. These can be easily lifted for bathroom visits and will be far more comfortable.\n" +
                "Keep elastic bands for holding your pants and sleeves up when making Wudhu to prevent them from getting wet.\n" +
                "Keep an emergency kit of plastic bags, small bottle (preferably squeezy, like a plastic ketchup bottle) of water for washing oneself and Wudhu, toilet paper, and even a small bucket or container if needed. This can be used for emergency bathroom needs and making Wudhu rather than standing for hours. Regardless of the number of toilet stations available, there are long queues at all of them and sometimes it is hours between leaving Arafah and arriving at Muzdalifah.\n" +
                "Take (perfume-free) liquid soap rather than a bar which becomes difficult to re-package once wet."));

        tipsModels.add(new TipsModel("Tips for Spiritual Productivity" , "Learn relevant duas to be recited when doing Hajj.\n" +
                "Do not just read from books but do dua from heart.\n" +
                "Have a dua diary: keep a notebook or a diary with all the names of the people and their duas which they would like you to make for them. It is also a great idea to pen down one’s own duas in the notebook. Start before you leave and write down your dua list for Arafat.\n" +
                "Plan ahead the conversation you will be having with your Lord! You will be prepared to converse and spill out what is in your heart to your Lord and weep to your heart’s content.\n" +
                "Pray for the people that are working during Hajj for your safety: police, doctors, cleaners and guides. Make dua for the oppressed, including Muslims in Syria, Palestine, and Burma.\n" +
                "Focus:\n" +
                "Stay unplugged! Only keep a cell for emergency use, but stay AS FAR AWAY from your life back home as you can; no email, no phone. Immerse yourself in the experience so that you can focus solely on your purpose: to do this act for the sake of Allah alone. You are among the select few whom Allah chose to visit His masjid.\n" +
                "Do not get too distracted with all the shopping there as it is easy to do so and concentrate on the real reason you are there.\n" +
                "Dear Hajji, don’t worry about your money, children, spouse, parents, brothers & sisters because you will be away. Just forget everything and do your Hajj faithfully and sincerely and Allah surely will keep them all safe. Feel your Hajj as it’s the first and last Hajj you will be able to do in your life because, generally, it’s not too easy to go to Hajj again.\n" +
                "Simply submit yourself to Allah as the journey begins. That switch must be flipped instantly! That is the only way the physical challenges become unimportant and one can accept every challenge as food for the soul. Otherwise the entire journey is likely to be spent in fretting over meaningless daily hassles that can spoil such a great opportunity!\n" +
                "Take Hajj as a journey. So travel light (open-minded and clean heart) and stay focused on your destination.\n" +
                "Make talbiyah (reciting labbaik) throughout and keep in mind your purpose here: you are working for the Akhirah.\n" +
                "Refrain from all and every kind of ‘bad talk’ (anger, hurtful words, slander, lies, etc.) from the moment that you have the intent to go on Hajj, from the days leading up to it till the day you leave, and every single day thereafter during Hajj.\n" +
                "Because of the long periods of time without bathroom access and on buses, eat less. Nothing is more distracting to ‘ibaadah and prayer than urgency to go to the bathroom. So minimize your eating; it’s the Sunnah!\n" +
                "Say bismillah whenever you begin to do something and always make dua."));
    }
}