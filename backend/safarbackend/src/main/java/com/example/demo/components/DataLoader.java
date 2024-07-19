package com.example.demo.components;

import com.example.demo.enums.Category;
import com.example.demo.enums.Continent;
import com.example.demo.enums.Region;
import com.example.demo.enums.Role;
import com.example.demo.models.*;
import com.example.demo.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {


    private final ItineraryRepository itineraryRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final DuaRepository duaRepository;
    private final PlannedAttractionRepository plannedAttractionRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final AttractionRepository attractionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments arguments) throws Exception {

//  User
        User zak = User.builder()
                .role(Role.USER)
                .name("Zakaria")
                .email("zak@gmail.com")
                .password(passwordEncoder.encode("password"))
                .build();

        User user = User.builder()
                .role(Role.USER)
                .email("tadiwadzvoti@hotmail.co.uk")
                .name("Tadiwanashe Dzvoti")
                .password(passwordEncoder.encode("password"))
                .build();

        userRepository.save(zak);
        userRepository.save(user);

//        Dua
        Dua startJourney = new Dua("Starting the journey","بِسْمِ اللَّهِ تَوَكَّلْتُ عَلَى اللَّهِ لاَ حَوْلَ وَلاَ قُوَّةَ إِلاَّ بِاللَّهِ","In the name of Allah, I trust in Allah; there is no might and no power but in Allah" ,"Bismillahi tawakkaltu alallahi la hawla wala quwwata illa billah", "For the following verse, Anas bin Malik (RA) narrates that Prophet Muhammad (PBUH) said that: “Whoever says upon leaving his house (recites the below-mentioned verses) it will be said to him: ‘You are guided, defended and protected.’ The devil will go far away from him.”" ,"Grade: Sahih (Al-Albani)\n" +
                "Reference: Sunan Abi Dawud 5095\n" +
                "In-book reference: Book 43, Hadith 323", Category.TRAVEL_DUA);
        duaRepository.save(startJourney);
        Dua hardshipOfTravel = new Dua("Seeking refuge with Allah from the hardships of travelling", " اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ وَعْثَاءِ السَّفَرِ وَكَآبَةِ الْمُنْقَلَبِ وَالْحَوْرِ بَعْدَ الْكَوْرِ وَدَعْوَةِ الْمَظْلُومِ وَسُوءِ الْمَنْظَرِ فِي الأَهْلِ وَالْمَالِ", "O Allah, I seek refuge with You from the hardships of travel and the sorrows of return, from loss after plenty, from the supplication of the one who has been wronged, and seeing some calamity befall my family or wealth.", "Allahumma inni a'udhu bika min wa'tha'is-safari, wa kabatil-munqalabi, wal-hawri ba'dal-kawri, wa da'watil-mazlumi, wa suw'il-munzari fil-ahli wal-mal", "It was narrated that 'Abdullah bin Sarjis said:\n" +
                "\"When the Prophet [SAW] traveled, he would seek refuge with Allah from the hardships of travel, and the sorrows of return, from loss after plenty, from the supplication of the one who has been wronged, and from seeing some calamity befall.\"", "Grade:\t Sahih (Darussalam) Reference\t : Sunan an-Nasa'i 5500\n" +
                "In-book reference\t : Book 50, Hadith 73", Category.TRAVEL_DUA);
        duaRepository.save(hardshipOfTravel);
        

        Dua timeOfDepature = new Dua("Supplication at the time of Riding",
                "سبحان الذي سخر لنا هذا وما كنا له مقرنين، وإنا إلي ربنا لمنقلبون. اللهم إنا نسألك في سفرنا هذا البر والتقوى، ومن العمل ما ترضي اللهم هون علينا سفرنا هذا واطو عنا بعده اللهم أنت الصاحب في السفر والخليفة في الأهل. اللهم إني أعوذ بك من وعثاء السفر وكآبة المنظر وسوء المنقلب في الأهل والمال والولد وإذا رجع قالهن وزاد فيهن آيبون تائبون عابدون لربنا حامدون",
                "Far removed from imperfection is the One Who has made this subservient to us, for we have no power to subjugate it, and certainly to our Rubb shall we return. O Allah, we ask You during this journey of ours for righteousness, piety and such deeds as are pleasing to You. O Allah, make easy for us this journey of ours and make the distance short for us. O Allah, You are our Companion during the journey and the Guardian of the family and the property in our absence. O Allah, I seek refuge in You from the hardships of travelling, unhappiness connected with ghastly scenes and evil turns in property and family)",
                "Subhanal-ladhi sakh-khara lana hadha, wa ma kunna lahu muqrinin, wa inna ila Rabbina lamunqalibun. Allahumma inna nas'aluka fi safarina hadh al-birra wat-taqwa, wa minal-'amali ma tarda. Allahumma hawwin 'alaina safarana hadha, watwi 'anna bu'dahu. Allahumma Antas-Sahibu fissafari, wal-Khalifatu fil- ahli. Allahumma inni a'udhu bika min wa'ta'is-safari, wa kaabatil- manzari, wa su'il-munqalabi fil-mali wal-ahli wal-waladi",
                "This hadith is about the importance of supplicating to Allah before and after travelling. Before setting out on a journey, the Prophet Muhammad would recite \"Allahu Akbar\" three times followed by a supplication asking Allah for righteousness, piety and such deeds as are pleasing to Him. He also asked Allah to make the journey easy and short for them. Upon returning from his travels, he would add additional words of praise in his supplication. This hadith teaches us that we should always remember to ask Allah for guidance during our travels so that we may return safely with good deeds done in His pleasure. We should also remember to thank Him upon our return home from our journeys.",
                "Source: Sahih Muslim" +
                        "Reference\t : Riyad as-Salihin 972\n" +
                        "In-book reference\t : Book 7, Hadith 17",
                Category.TRAVEL_DUA);
        duaRepository.save(timeOfDepature);
        Dua combiningPrayer = new Dua("What Has Been Related About Combining Two Prayers",
                "حَدَّثَنَا قُتَيْبَةُ بْنُ سَعِيدٍ، حَدَّثَنَا اللَّيْثُ بْنُ سَعْدٍ، عَنْ يَزِيدَ بْنِ أَبِي حَبِيبٍ، عَنْ أَبِي الطُّفَيْلِ، هُوَ عَامِرُ بْنُ وَاثِلَةَ عَنْ مُعَاذِ بْنِ جَبَلٍ، أَنَّ النَّبِيَّ صلى الله عليه وسلم كَانَ فِي غَزْوَةِ تَبُوكَ إِذَا ارْتَحَلَ قَبْلَ زَيْغِ الشَّمْسِ أَخَّرَ الظُّهْرَ إِلَى أَنْ يَجْمَعَهَا إِلَى الْعَصْرِ فَيُصَلِّيهِمَا جَمِيعًا وَإِذَا ارْتَحَلَ بَعْدَ زَيْغِ الشَّمْسِ عَجَّلَ الْعَصْرَ إِلَى الظُّهْرِ وَصَلَّى الظُّهْرَ وَالْعَصْرَ جَمِيعًا ثُمَّ سَارَ وَكَانَ إِذَا ارْتَحَلَ قَبْلَ الْمَغْرِبِ أَخَّرَ الْمَغْرِبَ حَتَّى يُصَلِّيَهَا مَعَ الْعِشَاءِ وَإِذَا ارْتَحَلَ بَعْدَ الْمَغْرِبِ عَجَّلَ الْعِشَاءَ فَصَلاَّهَا مَعَ الْمَغْرِبِ \u200F.\u200F قَالَ وَفِي الْبَابِ عَنْ عَلِيٍّ وَابْنِ عُمَرَ وَأَنَسٍ وَعَبْدِ اللَّهِ بْنِ عَمْرٍو وَعَائِشَةَ وَابْنِ عَبَّاسٍ وَأُسَامَةَ بْنِ زَيْدٍ وَجَابِرِ بْنِ عَبْدِ اللَّهِ \u200F.\u200F قَالَ أَبُو عِيسَى وَالصَّحِيحُ عَنْ أُسَامَةَ \u200F.\u200F وَرَوَى عَلِيُّ بْنُ الْمَدِينِيِّ عَنْ أَحْمَدَ بْنِ حَنْبَلٍ عَنْ قُتَيْبَةَ هَذَا الْحَدِيثَ \u200F",
                "\"While the Prophet as at the Battle of Tabuk, if he wanted to depart before the sun's decline he would delay Zuhr so that he could pray it together with Asr. If he wanted to depart after the sun's decline, he would hasten Asr to Zuhr, and pray Zuhr and Asr together, and then move it. If he wanted to depart before Maghrib he would delay Maghrib until he prayed it with Isha, and if he wanted to depart after Maghrib he would hasten Isha so that he would pray it along with Maghrib.\"",
                "",
                "",
                "Grade:\t Sahih (Darussalam)\t\t\n" +
                        "Reference\t : Jami` at-Tirmidhi 553\n" +
                        "In-book reference\t : Book 6, Hadith 10",
                Category.TRAVEL_VIRTUES);
        duaRepository.save(combiningPrayer);
        Dua template = new Dua("",
                "",
                "",
                "",
                "",
                "",
                Category.TRAVEL_VIRTUES);




        Dua travelPrayer = new Dua("Shortening The Prayer During Travels",
                "حَدَّثَنَا عَبْدُ الْوَهَّابِ بْنُ عَبْدِ الْحَكَمِ الْوَرَّاقُ الْبَغْدَادِيُّ، حَدَّثَنَا يَحْيَى بْنُ سُلَيْمٍ، عَنْ عُبَيْدِ اللَّهِ، عَنْ نَافِعٍ، عَنِ ابْنِ عُمَرَ، قَالَ سَافَرْتُ مَعَ النَّبِيِّ صلى الله عليه وسلم وَأَبِي بَكْرٍ وَعُمَرَ وَعُثْمَانَ فَكَانُوا يُصَلُّونَ الظُّهْرَ وَالْعَصْرَ رَكْعَتَيْنِ رَكْعَتَيْنِ لاَ يُصَلُّونَ قَبْلَهَا وَلاَ بَعْدَهَا \u200F.\u200F وَقَالَ عَبْدُ اللَّهِ لَوْ كُنْتُ مُصَلِّيًا قَبْلَهَا أَوْ بَعْدَهَا لأَتْمَمْتُهَا \u200F.\u200F قَالَ وَفِي الْبَابِ عَنْ عُمَرَ وَعَلِيٍّ وَابْنِ عَبَّاسٍ وَأَنَسٍ وَعِمْرَانَ بْنِ حُصَيْنٍ وَعَائِشَةَ \u200F.\u200F قَالَ أَبُو عِيسَى حَدِيثُ ابْنِ عُمَرَ حَدِيثٌ حَسَنٌ غَرِيبٌ لاَ نَعْرِفُهُ إِلاَّ مِنْ حَدِيثِ يَحْيَى بْنِ سُلَيْمٍ مِثْلَ هَذَا \u200F.\u200F قَالَ مُحَمَّدُ بْنُ إِسْمَاعِيلَ وَقَدْ رُوِيَ هَذَا الْحَدِيثُ عَنْ عُبَيْدِ اللَّهِ بْنِ عُمَرَ عَنْ رَجُلٍ مِنْ آلِ سُرَاقَةَ عَنْ عَبْدِ اللَّهِ بْنِ عُمَرَ \u200F.\u200F قَالَ أَبُو عِيسَى وَقَدْ رُوِيَ عَنْ عَطِيَّةَ الْعَوْفِيِّ عَنِ ابْنِ عُمَرَ أَنَّ النَّبِيَّ صلى الله عليه وسلم كَانَ يَتَطَوَّعُ فِي السَّفَرِ قَبْلَ الصَّلاَةِ وَبَعْدَهَا \u200F.\u200F وَقَدْ صَحَّ عَنِ النَّبِيِّ صلى الله عليه وسلم أَنَّهُ كَانَ يَقْصُرُ فِي السَّفَرِ وَأَبُو بَكْرٍ وَعُمَرُ وَعُثْمَانُ صَدْرًا مِنْ خِلاَفَتِهِ \u200F.\u200F وَالْعَمَلُ عَلَى هَذَا عِنْدَ أَكْثَرِ أَهْلِ الْعِلْمِ مِنْ أَصْحَابِ النَّبِيِّ صلى الله عليه وسلم وَغَيْرِهِمْ \u200F.\u200F وَقَدْ رُوِيَ عَنْ عَائِشَةَ أَنَّهَا كَانَتْ تُتِمُّ الصَّلاَةَ فِي السَّفَرِ \u200F.\u200F وَالْعَمَلُ عَلَى مَا رُوِيَ عَنِ النَّبِيِّ صلى الله عليه وسلم وَأَصْحَابِهِ وَهُوَ قَوْلُ الشَّافِعِيِّ وَأَحْمَدَ وَإِسْحَاقَ إِلاَّ أَنَّ الشَّافِعِيَّ يَقُولُ التَّقْصِيرُ رُخْصَةٌ لَهُ فِي السَّفَرِ فَإِنْ أَتَمَّ الصَّلاَةَ أَجْزَأَ عَنْهُ \u200F.\u200F",
                "Ibn Umar narrated:\n" +
                        "\"I traveled with the Prophet, Abu Bakr, Umar, and Uthman; they would pray Zuhr and Asr as two Rak'ah and two Rak'ah, not praying before them nor after them.\" And Ibn Umar said: \"If I was going to pray before it or after it then I would pray it complete.\"",
                "",
                "",
                "Grade:\t Hasan (Darussalam)\t\t\n" +
                        "Reference\t : Jami` at-Tirmidhi 544\n" +
                        "In-book reference\t : Book 6, Hadith 1",
                Category.TRAVEL_ETIQUETTE);
        duaRepository.save(travelPrayer);

        Dua returnPrayer = new Dua("Returning from a journey",
                "عن كعب بن مالك رضي الله عنه أن رسول الله صلى الله عليه وسلم كان إذا قدم من سفر بدأ بالمسجد فركع فيه ركعتين ",
                "\n" +
                        "Whenever the Messenger of Allah (ﷺ) returned from a journey, he would proceed straight to the mosque and perform two Rak'ah of (optional) prayer.",
                "",
                "",
                "Source: Sahih Bukhi and Muslim Reference\t : Riyad as-Salihin 988\n" +
                        "In-book reference\t : Book 7, Hadith 33",
                Category.TRAVEL_ETIQUETTE);
        duaRepository.save(returnPrayer);
        Dua returning = new Dua(" Supplication at the time of returning Home and on seeing one's Hometown",
                "\u200Fآيبون، تائبون ، عابدون ، لربنا حامدون",
                "We are returning in safety, turning to our Rubb, worshipping Him and praising Him",
                "Ayibuna, ta'ibuna, 'abiduna, li-Rabbina hamidun",
                "We returned with the Prophet (ﷺ) from a journey; and when we entered the suburbs of Al- Madinah, he (ﷺ) said: \"Ayibuna, ta'ibuna, 'abiduna, li-Rabbina hamidun (We are returning in safety, turning to our Rubb, worshipping Him and praising Him).\" He (ﷺ) continued repeating these words till we entered Al-Madinah.\n",
                "Source: Sahih Muslim Reference\t : Riyad as-Salihin 987\n" +
                        "In-book reference\t : Book 7, Hadith 32 ",
                Category.TRAVEL_VIRTUES);
        duaRepository.save(returning);

        Dua alight = new Dua("Supplication on Alighting at a Halt",
                "-عن خولة بنت حكيم رضي الله عنها قالت سمعت رسول الله صلى الله عليه وسلم يقول من نزل منزلاً ثم قال أعوذ بكلمات الله التامات من شر ما خلق لم يضره شيء حتي يرتحل من منزله ذلك",
                "I heard the Messenger of Allah (ﷺ) saying, \"Whosoever alights somewhere and says: 'A'udhu bikalimat-illahit-tammati min sharri ma khalaqa (I seek refuge with the Perfect Words of Allah from the evil of what He has created),' nothing will harm him until he leaves that place.\"\n",
                "",
                "",
                "Source: Sahih Muslim\n "+ "Reference\t : Riyad as-Salihin 982\n" +
                        "In-book reference\t : Book 7, Hadith 27",
                Category.TRAVEL_DUA);
        duaRepository.save(alight);

        Dua Leader = new Dua("Setting a leader",
                "عن أبي سعيد وأبي هريرة رضي الله عنهما قالا\u200F:\u200F قال رسول الله صلى الله عليه وسلم \u200F:\u200F “إذا خرج ثلاثة في سفر فليأمروا أحدهم\u200F\"\u200F حديث حسن، \u200F(\u200F\u200F(\u200Fرواه أبو داود بإسناد حسن\u200F)\u200F\u200F)\u200F\u200F.",
                "The Messenger of Allah (ﷺ) said, \"When three persons set out on a journey, they should appoint one of them as their leader.\"",
                "",
                "",
                "Source: Abu Dawud" +
                        "Reference\t : Riyad as-Salihin 960\n" +
                        "In-book reference\t : Book 7, Hadith 5\n",
                Category.TRAVEL_ETIQUETTE);
        duaRepository.save(Leader);

        Dua threeAccepted = new Dua("The three that have supplications accepted", " ثَلاَثُ دَعَوَاتٍ مُسْتَجَابَاتٌ لاَ شَكَّ فِيهِنَّ دَعْوَةُ الْمَظْلُومِ وَدَعْوَةُ الْمُسَافِرِ وَدَعْوَةُ الْوَالِدِ عَلَى وَلَدِهِ", "Three supplications are accepted , there is no doubt in them (about them being accepted): The supplication of the oppressed, the supplication of the traveler, and the supplication of his father against his son.", "",
                "Abu Hurairah [may Allah be pleased with him] narrated :\n" +
                        "that the Messenger of Allah said: “Three supplications are responded to: The supplication of the oppressed, the supplication of the traveler, and the supplication of the parent against his child.” Ali bin Hujr narrated to us (he said): Ismail bin Ibrahim reported to us from Hisham Ad-Dastawa’i, from Yahya bin Abu Kathir with this chain, narrating similar to it, but he added to it: “responded to, there is no doubt in them.” ","Grade:\t Hasan (Darussalam)\t\t\n" +
                "Reference\t : Jami` at-Tirmidhi 1905\n" +
                "In-book reference\t : Book 27, Hadith 11", Category.TRAVEL_VIRTUES);

        duaRepository.save(threeAccepted);

        Country china = new Country(Region.EAST_ASIA, Continent.ASIA, "https://cdn.kimkim.com/files/a/content_articles/featured_photos/d3e5c6d3636278dc1e489c6f9feb1f603581e0c5/big-b1717a87c8b279ddbb0601ac3d3e673b.jpg", "China");
        Country japan = new Country(Region.EAST_ASIA, Continent.ASIA, "https://res.klook.com/image/upload/q_85/c_fill,w_750/v1674030135/blog/bnbtltnp5nqbdevfcbmn.jpg", "Japan");
        Country indonesia = new Country(Region.SOUTH_EAST_ASIA, Continent.ASIA, "https://www.tripsavvy.com/thmb/QezCUEaQwF96o606XGU8DOn_TyI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/where-is-bali-5936c3e73df78c08abe9eb45.jpg", "Indonesia");
        Country vietnam = new Country(Region.SOUTH_EAST_ASIA, Continent.ASIA, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Terraced_fields_Sa_Pa_Vietnam.JPG/800px-Terraced_fields_Sa_Pa_Vietnam.JPG", "Vietnam");
        Country kyrgyzstan = new Country(Region.CENTRAL_ASIA, Continent.ASIA, "https://www.steppestravel.com/app/uploads/2019/07/kyrgyzstan.jpg", "Kyrgyzstan");
        Country australia = new Country(Region.OCEANIA, Continent.ASIA, "https://ymt-vacations-website.s3.amazonaws.com/uploads/2023/01/reef.jpg", "Australia");
        Country saudi = new Country(Region.MIDDLE_EAST, Continent.ASIA, "https://www.spectator.co.uk/wp-content/uploads/2023/06/GettyImages-52004477.jpg?w=1024", "Saudi Arabia");
        Country southKorea = new Country(Region.EAST_ASIA, Continent.ASIA, "https://149990825.v2.pressablecdn.com/wp-content/uploads/2023/09/Seoul1.jpg", "South Korea");
        Country thailand = new Country(Region.SOUTH_EAST_ASIA, Continent.ASIA, "https://feelgoodandtravel.com/wp-content/uploads/baby-elephant-two-adult-elephants-thailand.jpg", "Thailand");
        Country malaysia = new Country(Region.SOUTH_EAST_ASIA, Continent.ASIA, "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/473000/473015-Kuala-Lumpur.jpg", "Malaysia");
        Country oman = new Country(Region.MIDDLE_EAST, Continent.ASIA, "https://thetravelescape.com/wp-content/uploads/2018/03/Adventuring-in-Wadi-Shab-Oman-The-Travel-Escape-1.jpg", "Oman");
        Country qatar = new Country(Region.MIDDLE_EAST, Continent.ASIA, "https://m.thepeninsulaqatar.com/get/maximage/20221212_1670821215-945.jpg?1670821357", "Qatar");

        //FEATURED ASIA COUNTRY: Vietnam, Indoneisa, Japan, China, Kygryzstan, Austalia, South Korea, Thailand, Phillipinnes, Malaysia, Oman, Qatar, Saudi
//        Europe
        Country france = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://c.files.bbci.co.uk/15C01/production/_119398098_x1200france-gettyimages-847408280.jpg", "France");
        Country spain = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://www.myglobalviewpoint.com/wp-content/uploads/2023/06/Costa-del-Sol.jpg", "Spain");
        Country italy = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://www.ontheluce.com/wp-content/uploads/2022/06/Amalfi-Coast-1440x900.jpg.webp", "Italy");
        Country germany = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://www.planetware.com/photos-large/D/germany-brandenburg-gate.jpg", "Germany");
        Country turkey = new Country(Region.MEDITERRANEAN, Continent.EUROPE, "https://imagedelivery.net/0LMYosKeo5o-LXOCjdKUuA/tourscanner.com/2022/07/things-to-do-in-Cappadocia-Turkey.jpg/w=1200", "Turkey");
        Country austria = new Country(Region.CENTRAL_EUROPE, Continent.EUROPE, "https://www.interrail.eu/content/dam/blogazine/austria-hallstatt-lake-panorama-church-during-twilight.adaptive.767.1627562140844.png", "Austria");
        Country russia = new Country(Region.EASTERN_EUROPE, Continent.EUROPE, "https://www.justgorussia.co.uk/userfiles/images/gallery/altai/Depositphotos_1593654_m-2015.jpg", "Russia");
        Country portugal = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://media-server.clubmed.com/image/jpeg/1024/auto/crop/center/70/https%3A%2F%2Fns.clubmed.com%2Fnmea%2F2021%2FB2C%2F341%2FWEB%2FLANDING%2FPORTUGALBLOGS%2FLagos.jpg", "Portugal");
        Country switzerland = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://www.smartertravel.com/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2017/09/shutterstock_252539665.jpg.webp", "Switzerland");
        Country netherlands = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://i.natgeofe.com/k/4a509698-ab53-4581-af61-4c4808a81a76/netherlands-tulip-fields_16x9.jpg?w=1200", "the Netherlands");
        Country belgium = new Country(Region.WESTERN_EUROPE, Continent.EUROPE, "https://www.leboat.co.uk/sites/default/files/images/country/ghent_city_belgium_leboat_card.jpg", "Belgium");
        Country iceland = new Country(Region.SCANDINAVIA, Continent.EUROPE, "https://cdn.britannica.com/06/171306-050-C88DD752/Aurora-borealis-peninsula-Snaefellsnes-Iceland-March-2013.jpg", "Iceland");
        // Featured Europe Countries: Turkey, Switzerland, Austria, Italy, Spain, France, Greece, Portuga

        countryRepository.save(china);
        countryRepository.save(japan);
        countryRepository.save(indonesia);
        countryRepository.save(vietnam);
        countryRepository.save(turkey);
        countryRepository.save(kyrgyzstan);
        countryRepository.save(australia);
        countryRepository.save(saudi);
        countryRepository.save(southKorea);
        countryRepository.save(thailand);
        countryRepository.save(malaysia);
        countryRepository.save(oman);
        countryRepository.save(qatar);


        countryRepository.save(france);
        countryRepository.save(spain);
        countryRepository.save(italy);
        countryRepository.save(germany);
        countryRepository.save(turkey);
        countryRepository.save(austria);
        countryRepository.save(russia);
        countryRepository.save(portugal);
        countryRepository.save(switzerland);
        countryRepository.save(netherlands);
        countryRepository.save(belgium);
        countryRepository.save(iceland);

// CITIES
//        Europe
        // Top 5 cities in France
        City paris = new City("Paris", france);
        City marseille = new City("Marseille", france);
        City lyon = new City("Lyon", france);
        City toulouse = new City("Toulouse", france);
        City nice = new City("Nice", france);

// Save cities in France
        cityRepository.save(paris);
        cityRepository.save(marseille);
        cityRepository.save(lyon);
        cityRepository.save(toulouse);
        cityRepository.save(nice);

        // Top 5 cities in Italy
        City rome = new City("Rome", italy);
        City milan = new City("Milan", italy);
        City naples = new City("Naples", italy);

// Save cities in Italy
        cityRepository.save(rome);
        cityRepository.save(milan);
        cityRepository.save(naples);
// Top 5 cities in Portugal
        City lisbon = new City("Lisbon", portugal);
        City porto = new City("Porto", portugal);
        City azores = new City("Azores", portugal);
        City madeira = new City("Madeira", portugal);

// Save cities in Portugal
        cityRepository.save(lisbon);
        cityRepository.save(porto);
        cityRepository.save(azores);
        cityRepository.save(madeira);
// Top 5 cities in Spain
        City madrid = new City("Madrid", spain);
        City barcelona = new City("Barcelona", spain);
        City malaga = new City("Malaga", spain);

// Save cities in Spain
        cityRepository.save(madrid);
        cityRepository.save(barcelona);
        cityRepository.save(malaga);
// Top 5 cities in Germany
        City berlin = new City("Berlin", germany);
        City munich = new City("Munich", germany);


// Save cities in Germany
        cityRepository.save(berlin);
        cityRepository.save(munich);

// Top 5 cities in Turkey
        City istanbul = new City("Istanbul", turkey);
        City cappadocia = new City("Cappadocia", turkey);
        City antalya = new City("Antalya", turkey);

// Save cities in Turkey
        cityRepository.save(istanbul);
        cityRepository.save(cappadocia);
        cityRepository.save(antalya);
// Top 5 cities in Austria
        City vienna = new City("Vienna", austria);
        City innsbruck = new City("Innsbruck", austria);

// Save cities in Austria
        cityRepository.save(vienna);
        cityRepository.save(innsbruck);


// Top 5 cities in Switzerland
        City zurich = new City("Zurich", switzerland);
        City geneva = new City("Geneva", switzerland);
        City basel = new City("Basel", switzerland);


// Save cities for Switzerland
        cityRepository.save(zurich);
        cityRepository.save(geneva);
        cityRepository.save(basel);

// Top 5 destinations in Iceland
        City reykjavik = new City("Reykjavik", iceland);

// Save Icelandic destinations as cities
        cityRepository.save(reykjavik);

// Top 5 cities in Russia
        City moscow = new City("Moscow", russia);
        City saintPetersburg = new City("Saint Petersburg", russia);

        // Save cities in Russia

        cityRepository.save(moscow);
        cityRepository.save(saintPetersburg);

        // Top 5 cities in the Netherlands
        City amsterdam = new City("Amsterdam", netherlands);
        City rotterdam = new City("Rotterdam", netherlands);


// Save cities in the Netherlands
        cityRepository.save(amsterdam);
        cityRepository.save(rotterdam);
// Top 5 cities in Belgium
        City brussels = new City("Brussels", belgium);
        City antwerp = new City("Antwerp", belgium);
        City ghent = new City("Ghent", belgium);
        City bruges = new City("Bruges", belgium);
        City liege = new City("Liege", belgium);

// Save cities in Belgium
        cityRepository.save(brussels);
        cityRepository.save(antwerp);
        cityRepository.save(ghent);
        cityRepository.save(bruges);
        cityRepository.save(liege);

// Top 5 cities in Vietnam
        City hanoi = new City("Hanoi", vietnam);
//        City hoChiMinhCity = new City("Ho Chi Minh City", vietnam);
        City daNang = new City("Da Nang", vietnam);
//        City haiPhong = new City("Hai Phong", vietnam);
//        City canTho = new City("Can Tho", vietnam);
        City hoiAn = new City("Hoi An", vietnam);
        City nhaTrang = new City("Nha Tranga", vietnam);

// Top 5 cities in Indonesia
        City jakarta = new City("Jakarta", indonesia);
        City surabaya = new City("Surabaya", indonesia);
        City bandung = new City("Bandung", indonesia);
        City medan = new City("Medan", indonesia);
        City semarang = new City("Semarang", indonesia);
        City yogyakarta = new City("Yogyakarta", indonesia);

// Top 5 cities in Japan
        City tokyo = new City("Tokyo", japan);
        City osaka = new City("Osaka", japan);
        City nagoya = new City("Nagoya", japan);
        City sapporo = new City("Sapporo", japan);
        City yokohama = new City("Yokohama", japan);

// Top 5 cities in China
        City beijing = new City("Beijing", china);
        City shanghai = new City("Shanghai", china);
        City guangzhou = new City("Guangzhou", china);
        City shenzhen = new City("Shenzhen", china);
        City chengdu = new City("Chengdu", china);


// Top 5 cities in Kyrgyzstan
        City bishkek = new City("Bishkek", kyrgyzstan);
        City osh = new City("Osh", kyrgyzstan);
        City jalalAbad = new City("Jalal-Abad", kyrgyzstan);
        City karakol = new City("Karakol", kyrgyzstan);
        City tokmok = new City("Tokmok", kyrgyzstan);

// Top 5 cities in Australia
        City sydney = new City("Sydney", australia);
        City melbourne = new City("Melbourne", australia);
        City brisbane = new City("Brisbane", australia);
        City perth = new City("Perth", australia);
        City adelaide = new City("Adelaide", australia);

// Top 5 cities in Saudi
        City riyadh = new City("Riyadh", saudi);
        City jeddah = new City("Jeddah", saudi);
        City mecca = new City("Mecca", saudi);
        City medina = new City("Medina", saudi);
        City dammam = new City("Dammam", saudi);

// Muscat in Oman
        City muscat = new City("Muscat", oman);

// Top cities in Qatar
        City doha = new City("Doha", qatar);
        City lusail = new City("Lusail", qatar);
// Top 5 cities in southKorea
        City seoul = new City("Seoul", southKorea);
        City busan = new City("Busan", southKorea);
        City incheon = new City("Incheon", southKorea);


// Top 5 cities in thailiand
        City bangkok = new City("Bangokok", thailand);
        City chiangMai = new City("Ciang Mai", thailand);
        City phuket = new City("Phuket", thailand);
        City pattaya = new City("Pattaya", thailand);
        City nonthaburi = new City("Nonthaburi", thailand);

// Top 5 cities in Malaysia
        City kualaLumpur = new City("Kuala Lumpar", malaysia);
        City georgeTown = new City("George Town", malaysia);
        City johorBahru = new City("Johor Bahru", malaysia);
        City ipoh = new City("Ipoh", malaysia);
        City kuching = new City("Kuching", malaysia);

// Save cities for Vietnam
        cityRepository.save(hanoi);
//        cityRepository.save(hoChiMinhCity);
        cityRepository.save(daNang);
//        cityRepository.save(haiPhong);
//        cityRepository.save(canTho);
        cityRepository.save(hoiAn);
        cityRepository.save(nhaTrang);

// Save cities for Indonesia
        cityRepository.save(jakarta);
        cityRepository.save(surabaya);
        cityRepository.save(bandung);
        cityRepository.save(medan);
        cityRepository.save(semarang);
        cityRepository.save(yogyakarta);

// Save cities for Japan
        cityRepository.save(tokyo);
        cityRepository.save(osaka);
        cityRepository.save(nagoya);
        cityRepository.save(sapporo);
        cityRepository.save(yokohama);


// Save cities for China
        cityRepository.save(beijing);
        cityRepository.save(shanghai);
        cityRepository.save(guangzhou);
        cityRepository.save(shenzhen);
        cityRepository.save(chengdu);

// Continue saving cities for other countries...
// Save cities in Kyrgyzstan
        cityRepository.save(bishkek);
        cityRepository.save(osh);
        cityRepository.save(jalalAbad);
        cityRepository.save(karakol);
        cityRepository.save(tokmok);
        // Save cities in Australia
        cityRepository.save(sydney);
        cityRepository.save(melbourne);
        cityRepository.save(brisbane);
        cityRepository.save(perth);
        cityRepository.save(adelaide);

        // Save Cities in Saudi Arabia
        cityRepository.save(riyadh);
        cityRepository.save(jeddah);
        cityRepository.save(mecca);
        cityRepository.save(medina);
        cityRepository.save(dammam);

        // Save Cities for Oman
        cityRepository.save(muscat);

        // Save Cities for Qatar
        cityRepository.save(doha);
        cityRepository.save(lusail);

        // Save Cities for South Korea
        cityRepository.save(seoul);
        cityRepository.save(incheon);
        cityRepository.save(busan);

        // Save Cities for Thailand
        cityRepository.save(bangkok);
        cityRepository.save(phuket);
        cityRepository.save(pattaya);
        cityRepository.save(nonthaburi);
        cityRepository.save(chiangMai);

        // Save Cities for Malaysia
        cityRepository.save(kualaLumpur);
        cityRepository.save(georgeTown);
        cityRepository.save(johorBahru);
        cityRepository.save(ipoh);
        cityRepository.save(kuching);

// ATTRACTIONS
//Europe

        // Create Attraction objects for top 5 attractions in Paris with longer descriptions
        Attraction eiffelTower = new Attraction("Eiffel Tower", paris, "The Eiffel Tower, named after engineer Gustave Eiffel, is a global cultural icon of France and one of the most recognizable structures in the world. Standing at 324 meters (1,063 feet), it is the tallest structure in Paris and has welcomed millions of visitors since its completion in 1889. Visitors can ascend to its observation decks for breathtaking panoramic views of the city, dine at its restaurants, or learn about its history at the Eiffel Tower Museum located on the first floor.", "https://images.squarespace-cdn.com/content/v1/58fbfecf725e25a3d1966494/1617153558938-JPZWR94CWYCRICXG933L/image-asset.jpeg");
        Attraction louvreMuseum = new Attraction("Louvre Museum", paris, "The Louvre Museum, housed in the Louvre Palace, is the world's largest art museum and a historic monument in Paris. It is home to over 38,000 objects, including the Mona Lisa, Venus de Milo, and Winged Victory of Samothrace. Visitors can explore its vast collections spanning thousands of years of art and history, from ancient civilizations to the present day.", "https://www.relaisdulouvre.com/wp-content/uploads/2024/03/Louvre1-1024x682.jpg");
        Attraction arabWorldInstitute = new Attraction("Arab World Institute", paris, "The Arab World Institute is a cultural institute dedicated to the Arab world. It showcases exhibits on Arab culture, art, history, and civilization. Visitors can explore Islamic art, calligraphy, and artifacts.", "https://media02.stockfood.com/largepreviews/MjIwNDY0ODU0NQ==/71117695-France-Paris-Institut-du-Monde-Arabe-Arab-World-Institute-by-architect-Jean-Nouvel-and-Architecture-studio.jpg");
        Attraction montmartre = new Attraction("Montmartre and Sacré-Cœur Basilica", paris, "Montmartre is a historic neighborhood in Paris known for its artistic heritage, charming streets, and vibrant atmosphere. Visitors can explore the winding streets of Montmartre, visit art studios and galleries, or enjoy street performances by local artists.", "https://blushrougette.com/wp-content/uploads/2021/07/sacre-coeur-basilica-paris.jpg");
        Attraction seineRiverCruise = new Attraction("Seine River Cruise", paris, "A Seine River cruise offers a leisurely way to explore Paris and its iconic landmarks from a different perspective. As you glide along the Seine, you'll pass by famous sights such as the Eiffel Tower, and Louvre Museum, all while enjoying commentary about the city's history and architecture. Whether during the day or illuminated at night, a Seine River cruise provides unforgettable views of Paris.", "https://media.timeout.com/images/105347952/image.jpg");
        Attraction museeDOrsay = new Attraction("Musée d'Orsay", paris, "The Musée d'Orsay is a renowned art museum located on the left bank of the Seine River in Paris. Housed in a former railway station, the museum is celebrated for its extensive collection of Impressionist and Post-Impressionist masterpieces, including works by Monet, Van Gogh, Renoir, and Degas. Visitors can explore the museum's galleries to admire these iconic artworks and gain insights into the development of modern art.", "https://media.architecturaldigest.com/photos/5e627c75664e8c00083cbbf8/16:9/w_1952,h_1098,c_limit/Nef%20avec%20horloge%20(c)%20Sophie%20Cre%CC%81py.jpg");

// Save attractions in the database
        attractionRepository.save(eiffelTower);
        attractionRepository.save(louvreMuseum);
        attractionRepository.save(arabWorldInstitute);
        attractionRepository.save(montmartre);
        attractionRepository.save(seineRiverCruise);
        attractionRepository.save(museeDOrsay);

        // Create Attraction objects for top 5 attractions in Marseille
        Attraction vieuxPort = new Attraction("Vieux Port (Old Port)", marseille, "The Vieux Port is the historic harbor of Marseille, dating back to ancient Greek times. Today, it is a bustling waterfront area lined with cafes, restaurants, and shops. Visitors can stroll along the promenade, watch fishing boats come and go, or take a boat tour of the harbor.", "https://www.kayak.co.uk/rimg/himg/99/d3/63/ice-36133-71642626_3XL-226284.jpg?width=1366&height=768&crop=true");
        Attraction lePanier = new Attraction("Le Panier (The Old Town)", marseille, "Le Panier is Marseille's oldest neighborhood, with narrow cobblestone streets, colorful houses, and charming squares. It is a vibrant area filled with artisan boutiques, galleries, and cafes. Visitors can wander through its winding alleys, admire street art, and soak in the lively atmosphere.", "https://media01.stockfood.com/largepreviews/MjIxMTg1MTMwMg==/71350042-The-narrow-streets-of-the-old-town-Le-Panier-Marseille-Bouches-du-Rhone-Provence-France-Mediterranean-Europe.jpg");
        Attraction muCEM = new Attraction("MuCEM (Museum of European and Mediterranean Civilisations)", marseille, "The MuCEM is a modern museum dedicated to the cultures of Europe and the Mediterranean region. Housed in a striking contemporary building overlooking the sea, it features exhibits on history, art, and anthropology. Visitors can explore its collections, attend cultural events, and enjoy panoramic views from its rooftop terrace.", "https://arquitecturaviva.com/assets/uploads/obras/44229/av_imagen.webp");
        Attraction calanquesNationalPark = new Attraction("Calanques National Park", marseille, "Calanques National Park is a stunning natural reserve located just outside Marseille. It is known for its rugged limestone cliffs, hidden coves, and crystal-clear waters. Visitors can hike along scenic trails, swim in secluded beaches, or take a boat tour to explore the park's picturesque coastline.", "https://media.timeout.com/images/105965990/image.jpg");

// Save attractions in the database
        attractionRepository.save(vieuxPort);
        attractionRepository.save(lePanier);
        attractionRepository.save(muCEM);
        attractionRepository.save(calanquesNationalPark);

// Create Attraction objects for top 5 attractions in Lyon
        Attraction vieuxLyon = new Attraction("Vieux Lyon (Old Lyon)", lyon, "Vieux Lyon is the historic heart of Lyon, with well-preserved Renaissance buildings, narrow cobblestone streets, and traboules (hidden passageways). It is a UNESCO World Heritage Site and a bustling area filled with shops, restaurants, and museums. Visitors can explore its medieval architecture and savor traditional Lyonnaise cuisine.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/da/01/47/vieux-lyon.jpg?w=1200&h=-1&s=1");
        Attraction museeDesBeauxArts = new Attraction("Musée des Beaux-Arts de Lyon (Museum of Fine Arts of Lyon)", lyon, "The Musée des Beaux-Arts de Lyon is one of France's largest and most important art museums, housed in a former Benedictine convent. It features a vast collection of paintings, sculptures, and decorative arts spanning from antiquity to the present day. Visitors can admire works by masters such as Rembrandt, Monet, and Picasso, as well as explore temporary exhibitions and educational programs.", "https://image.jimcdn.com/app/cms/image/transf/none/path/s2b5225e21de9ed64/image/ic83f299dd3ba0d2b/version/1422217498/image.jpg");
        Attraction parcDeLaTeteDor = new Attraction("Parc de la Tête d'Or (Park of the Golden Head)", lyon, "Parc de la Tête d'Or is a sprawling urban park in Lyon, known for its lush greenery, botanical gardens, and scenic lake. It offers a tranquil escape from the city's hustle and bustle, with walking paths, playgrounds, and recreational activities. Visitors can relax amid nature, enjoy picnics, or explore attractions such as the zoo and rose garden.", "https://www.loisirs-parcdelatetedor.com/wordpress/wp-content/uploads/2014/02/Girafes.jpg");
        Attraction croixRousse = new Attraction("La Croix-Rousse", lyon, "La Croix-Rousse is a historic neighborhood in Lyon known for its silk industry and working-class heritage. It is characterized by its steep streets, red-brick buildings, and lively atmosphere. Visitors can explore its markets, art galleries, and workshops, and learn about its rich cultural history. The neighborhood also offers panoramic views of Lyon from its terraces.", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Croix-Rousse_vue_de_Fourvi%C3%A8re.jpg/800px-Croix-Rousse_vue_de_Fourvi%C3%A8re.jpg");

// Save attractions in the database
        attractionRepository.save(vieuxLyon);
        attractionRepository.save(museeDesBeauxArts);
        attractionRepository.save(parcDeLaTeteDor);
        attractionRepository.save(croixRousse);
// Create Attraction objects for top 5 attractions in Toulouse
        Attraction capitole = new Attraction("Capitole de Toulouse (Capitolium of Toulouse)", toulouse, "The Capitole de Toulouse is the city hall of Toulouse and a symbol of its civic pride. Located on the Place du Capitole, it is an impressive neoclassical building with a pink-marble facade, columned portico, and grand staircase. Visitors can explore its interior adorned with paintings and ornate decorations, and stroll through the square's bustling markets and cafes.", "https://upload.wikimedia.org/wikipedia/commons/4/4e/Toulouse_Capitole_Night_Wikimedia_Commons.jpg");
        Attraction citeDeLEspace = new Attraction("Cité de l'Espace (City of Space)", toulouse, "The Cité de l'Espace is a space-themed amusement park and museum in Toulouse, dedicated to space exploration and astronomy. It features interactive exhibits, educational displays, and full-scale replicas of spacecraft and satellites. Visitors can experience simulated space missions, explore the cosmos in the planetarium, and learn about the history and future of space travel.", "https://avestagroup.eu/wp-content/uploads/2021/10/planetarium-citedelespace-credits-pascal-prieur-copie.jpg");
        Attraction jardinDesPlantes = new Attraction("Jardin des Plantes (Garden of Plants)", toulouse, "The Jardin des Plantes is a botanical garden and park in Toulouse, known for its diverse plant collections, scenic landscapes, and historic buildings. It offers a peaceful retreat in the heart of the city, with walking paths, ponds, and greenhouses. Visitors can admire exotic plants, enjoy picnics, or attend events and exhibitions throughout the year.", "https://a.cdn-hotels.com/gdcs/production176/d1301/54114904-9575-4a2b-ab3c-ec4e84fbb31c.jpg");
        Attraction pontNeuf = new Attraction("Pont Neuf", toulouse, "Pont Neuf is the oldest bridge in Toulouse and a historic landmark spanning the Garonne River. Built in the 16th and 17th centuries, it features elegant arches, stone balustrades, and ornate sculptures. Visitors can stroll across the bridge, admire views of the river and city skyline, or relax on its shady benches.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgzknotgz4Zbbfn9LjPfXq01Jh_qhjcdCuqg&s");

// Save attractions in the database
        attractionRepository.save(capitole);
        attractionRepository.save(citeDeLEspace);
        attractionRepository.save(jardinDesPlantes);
        attractionRepository.save(pontNeuf);
//        Attractions for Nice

        Attraction verdonGorge = new Attraction("Verdon Gorge", nice, "Verdon Gorge, also known as the Grand Canyon of Verdon, is a breathtaking natural wonder located in southeastern France. Carved by the Verdon River, the gorge boasts stunning turquoise waters, towering limestone cliffs, and dramatic landscapes. Visitors can explore the gorge by hiking along its scenic trails, kayaking or canoeing in its emerald waters, or simply admiring its beauty from viewpoints such as Point Sublime and Route des Crêtes.", "https://en.cite-espace.com/assets/uploads/cite-espace-vue-generale.jpg");
        Attraction ezeVillage = new Attraction("Eze Village", nice, "Eze Village is a charming medieval hilltop village located near Nice, France. Perched high above the Mediterranean Sea, it offers stunning panoramic views of the French Riviera coastline. Visitors can wander through narrow cobblestone streets, explore ancient stone buildings, and discover artisan shops, art galleries, and cafes nestled within the village walls.", "https://www.meganstarr.com/wp-content/uploads/2023/10/Views-over-the-French-Riviera-from-Eze_1659654976.jpg");
        Attraction antibesOldTown = new Attraction("Antibes Old Town", nice, "Antibes Old Town, also known as Vieil Antibes, is a historic district located along the French Riviera, between Cannes and Nice. Enclosed by ancient ramparts, it is characterized by narrow cobblestone streets, colorful buildings, and bustling markets. Visitors can explore its medieval architecture, visit landmarks such as the 16th-century Fort Carré and Picasso Museum, and stroll along the charming waterfront promenade.", "https://www.absoluty.com/wp-content/uploads/2023/03/antibes-old-town.png");
        Attraction islamicCulturalCenter = new Attraction("Islamic Cultural Center of Nice (Centre Culturel Islamique de Nice)", null, "The Islamic Cultural Center of Nice, also known as Centre Culturel Islamique de Nice, is a cultural and educational institution serving the Muslim community in Nice. It offers religious services, Islamic education programs, and cultural events aimed at promoting interfaith dialogue and understanding.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/ba/3c/a9/the-fanar-from-a-different.jpg?w=1200&h=-1&s=1");
        Attraction openSkyNice = new Attraction("Open Sky Area in Nice", nice, "The Open Sky Area in Nice is a unique public space located along the Promenade des Anglais, offering stunning views of the Mediterranean Sea and the city's iconic coastline. This expansive open-air area provides a picturesque setting for leisurely strolls, picnics, and outdoor activities. Visitors can relax on sun-drenched benches, soak in the sea breeze, and admire the vibrant colors of the sky as the sun sets over the horizon. The Open Sky Area in Nice is a popular gathering spot for locals and tourists alike, providing a perfect blend of natural beauty and urban charm.", "https://www.explorenicecotedazur.com/content/uploads/2021/08/23275_0_5f156269bc94e.jpeg");

// Save attraction in the database
        attractionRepository.save(openSkyNice);
        attractionRepository.save(ezeVillage);
        attractionRepository.save(verdonGorge);
        attractionRepository.save(antibesOldTown);
        attractionRepository.save(islamicCulturalCenter);

//      Attractions for Rome
        Attraction colosseum = new Attraction("Colosseum (Colosseo)", rome, "The Colosseum, also known as the Flavian Amphitheatre, is an ancient Roman landmark located in the heart of Rome. Built in the 1st century AD, it is the largest amphitheater ever built and is considered one of the greatest works of Roman architecture. Visitors can explore its ruins, learn about its history as a venue for gladiatorial contests and public spectacles, and admire its iconic architecture.", "https://aws-tiqets-cdn.imgix.net/images/content/025ec3216a504f5da43f23f2e2cf5379.jpg?auto=format&fit=crop&ixlib=python-3.2.1&q=70&s=cbb71eecaa77f13f9dc588a9a25b1251");
        Attraction piazzaVittorioEmanuele = new Attraction("Piazza Vittorio Emanuele II", rome, "Piazza Vittorio Emanuele II is a lively square located in the Esquilino district of Rome. It is home to a diverse community, including a significant Muslim population. Visitors can explore the multicultural atmosphere of the square, visit halal shops and eateries, and experience the vibrant street life of this cosmopolitan neighborhood.", "https://tourismmedia.italia.it/is/image/mitur/2480X1000_piazza_vittorio_emanuele_roma_destination-1?wid=1240&hei=500&fit=constrain,1&fmt=webp");
// Save attraction in the database
        attractionRepository.save(piazzaVittorioEmanuele);
        attractionRepository.save(colosseum);

//        Attractions for Milan
        Attraction parcoDelleCave = new Attraction("Parco delle Cave", milan, "Parco delle Cave is a public park located in the southern outskirts of Milan. It offers a peaceful retreat from the city center and features walking trails, picnic areas, and scenic views of the surrounding nature. Muslim visitors can enjoy leisurely walks, outdoor activities, and serene moments of reflection in this natural setting.", "https://www.hitsicily.com/indi/_pics/9/1/parco-delle-cave-sicily-6_791_19216.jpg");
        Attraction sanSiroStadium = new Attraction("San Siro Stadium (Stadio Giuseppe Meazza)", milan, "San Siro Stadium, officially known as Stadio Giuseppe Meazza, is a world-renowned football stadium located in Milan. It is home to two of Italy's most successful football clubs, AC Milan and Inter Milan. The stadium has a rich history and has hosted numerous international football matches, including UEFA Champions League finals and FIFA World Cup games. Visitors can take guided tours of the stadium, explore its facilities, and learn about the illustrious footballing legacy of San Siro.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3tgyW-5siQR3gb9Tt57AntdECgVkyr2Mdmg&s");
        Attraction sforzaCastle = new Attraction("Sforza Castle (Castello Sforzesco)", milan, "Sforza Castle, also known as Castello Sforzesco, is a historic fortress located in the center of Milan. It was built in the 15th century by the Duke of Milan and later served as a residence for various rulers. Today, it houses several museums and art collections, including the Museum of Ancient Art, the Museum of Musical Instruments, and the Egyptian Museum.", "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQSUTSMLT5-FRV4UYJDcjEQYeW8uy0ToKho5OiD_b5y7KYB7gtK6VPwS4YDjMwXVQ8XKk4fxnQ1lOtpUEQLi68tz4JHwnEc1MD3OSZQj4Y");
        Attraction galleriaVittorioEmanuele = new Attraction("Galleria Vittorio Emanuele II", milan, "Galleria Vittorio Emanuele II is a historic shopping arcade and one of the oldest shopping malls in the world. Located next to the Milan Cathedral, it is renowned for its stunning architecture, including glass-vaulted ceilings and ornate decorations. Visitors can shop at luxury boutiques, dine at elegant cafes, and admire the grandeur of the arcade.", "https://www.introducingmilan.com/f/italia/milan/guia/galleria-vittorio-emanuele-ii-m.jpg");
        Attraction dolomiteMountains = new Attraction("Dolomite Mountains (Dolomiti)", milan, "The Dolomite Mountains, or Dolomiti in Italian, are a UNESCO World Heritage site and one of the most stunning natural landscapes in Italy. Located in the northeastern part of the country, the Dolomites are known for their dramatic peaks, rugged cliffs, and picturesque valleys. Visitors can enjoy a range of outdoor activities, including hiking, skiing, rock climbing, and mountain biking. The Dolomites offer breathtaking views and unforgettable experiences for nature lovers and outdoor enthusiasts.", "https://images.squarespace-cdn.com/content/v1/5174cbaee4b08db710752300/1515122759838-OODIXM39UN5LCINYIWLD/LDA31147.jpg");
        Attraction lakeComo = new Attraction("Lake Como (Lago di Como)", milan, "Lake Como, or Lago di Como in Italian, is a breathtaking lake located in the Lombardy region of northern Italy. Surrounded by majestic mountains and verdant hillsides, Lake Como is famous for its stunning scenery, elegant villas, and charming lakeside towns. Visitors can take boat cruises across the lake, explore picturesque villages like Bellagio, Varenna, and Menaggio, and enjoy leisurely walks along the scenic waterfront promenades. With its natural beauty and serene atmosphere, Lake Como is a must-visit destination for travelers seeking relaxation and romance.", "https://images.ctfassets.net/i3kf1olze1gn/3SMf6PdtYk4Hf8YfaOi75c/12148d870e520297c77bd41e0bf2c65f/Varenna_lake_como.jpg");
// Save attraction in the database
        attractionRepository.save(lakeComo);
        attractionRepository.save(dolomiteMountains);
        attractionRepository.save(galleriaVittorioEmanuele);
        attractionRepository.save(sforzaCastle);
        attractionRepository.save(sanSiroStadium);
        attractionRepository.save(parcoDelleCave);

//Naples

        Attraction mountVesuvius = new Attraction("Mount Vesuvius (Monte Vesuvio)", naples, "Mount Vesuvius is one of the most famous volcanoes in the world, known for its eruption in 79 AD that buried the ancient cities of Pompeii and Herculaneum. Today, it is a popular tourist destination, offering hiking trails to the crater rim and breathtaking views of the Bay of Naples. Visitors can learn about the volcano's geology, history, and impact on the surrounding landscape.", "https://media.hswstatic.com/eyJidWNrZXQiOiJjb250ZW50Lmhzd3N0YXRpYy5jb20iLCJrZXkiOiJnaWZcL210LXZlc3V2aXVzLmpwZyIsImVkaXRzIjp7InJlc2l6ZSI6eyJ3aWR0aCI6ODI4fX19");
        Attraction pompeiiArchaeologicalPark = new Attraction("Pompeii Archaeological Park (Parco Archeologico di Pompei)", naples, "The Pompeii Archaeological Park is a UNESCO World Heritage site that preserves the ancient Roman city of Pompeii, which was buried under volcanic ash during the eruption of Mount Vesuvius in 79 AD. Visitors can explore the remarkably well-preserved ruins of Pompeii, including streets, houses, and public buildings, and learn about daily life in ancient Rome.", "https://www.gatto-rosso.com/templates/yootheme/cache/50/Pompei-copertina_home-506a0aa9.jpeg");
        Attraction capriIsland = new Attraction("Capri Island (Isola di Capri)", naples, "Capri is a picturesque island located in the Bay of Naples, known for its stunning natural beauty, rugged coastline, and luxury resorts. Visitors can explore the charming town of Capri, take boat tours to iconic landmarks such as the Blue Grotto and the Faraglioni rock formations, and enjoy leisurely walks along scenic hiking trails. Capri offers a perfect blend of relaxation and adventure in a breathtaking Mediterranean setting.", "https://idsb.tmgrup.com.tr/ly/uploads/images/2021/06/14/121700.jpg");
        Attraction amalfiCoast = new Attraction("Amalfi Coast (Costiera Amalfitana)", naples, "The Amalfi Coast is a stunning stretch of coastline in southern Italy, known for its dramatic cliffs, colorful fishing villages, and picturesque towns. Visitors can drive along the scenic coastal road, stopping in charming villages such as Positano, Amalfi, and Ravello, each offering breathtaking views of the Mediterranean Sea. The Amalfi Coast is also famous for its delicious cuisine, lemon groves, and historic landmarks, making it a must-visit destination for travelers seeking natural beauty and cultural experiences.", "https://lp-cms-production.imgix.net/2024-04/shutterstock2196433383.jpg?auto=format&w=780&h=425&fit=crop&q=75");
        Attraction positano = new Attraction("Positano", naples, "Positano is a charming coastal town located on the Amalfi Coast in southern Italy. Known for its colorful cliffside houses, narrow streets, and stunning views of the Tyrrhenian Sea, Positano is a popular destination for travelers seeking romance and relaxation. Visitors can explore its picturesque beaches, shop for local ceramics and fashion, and dine at seaside restaurants serving fresh seafood and regional specialties. With its unique beauty and laid-back atmosphere, Positano offers a memorable experience for visitors exploring the Amalfi Coast.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2b/28/58/15/caption.jpg?w=1200&h=-1&s=1");

// Save attraction in the database
        attractionRepository.save(positano);
        attractionRepository.save(amalfiCoast);
        attractionRepository.save(capriIsland);
        attractionRepository.save(mountVesuvius);
        attractionRepository.save(pompeiiArchaeologicalPark);

// Attractions for Lisbon
        // Create Attraction object for Belém Tower
        Attraction belemTower = new Attraction("Belém Tower (Torre de Belém)", lisbon, "The Belém Tower, or Torre de Belém in Portuguese, is an iconic fortress located on the banks of the Tagus River in Lisbon. Built in the 16th century during the Age of Discovery, it served as a defensive structure and ceremonial gateway to the city. Today, it is a UNESCO World Heritage site and one of Lisbon's most recognizable landmarks. Visitors can explore its impressive architecture, climb to the top for panoramic views of the river and city, and learn about Portugal's maritime history.", "https://www.lisbon.net/f/portugal/lisboa/guia/torre-belem-m.jpg");
        Attraction sintra = new Attraction("Sintra", lisbon, "Sintra is a charming town located just outside of Lisbon, nestled amidst the lush hills of the Serra de Sintra. It is renowned for its fairy-tale palaces, enchanting gardens, and romantic atmosphere. Visitors can explore iconic landmarks such as the colorful Pena Palace, the mysterious Quinta da Regaleira, and the historic Moorish Castle. Sintra's magical ambiance and architectural wonders make it a popular day trip destination from Lisbon.", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Sintra_-_Palacio_da_Pena_%2820332995770%29_%28cropped2%29.jpg/1200px-Sintra_-_Palacio_da_Pena_%2820332995770%29_%28cropped2%29.jpg");
        Attraction cascais = new Attraction("Cascais", lisbon, "Cascais is a charming coastal town located just west of Lisbon, Portugal. Once a sleepy fishing village, it has transformed into a popular resort destination known for its beautiful beaches, historic architecture, and vibrant atmosphere. Visitors can stroll along the scenic waterfront promenade, relax on sandy beaches like Praia da Rainha and Praia do Guincho, and explore attractions such as the Cascais Citadel and the Museum of the Sea. Cascais offers a perfect blend of relaxation and culture, making it a delightful day trip from Lisbon.", "https://www.cascaisportugaltourism.com/images/cascais-portugal.jpg");
        Attraction oceanarioDeLisboa = new Attraction("Oceanário de Lisboa", lisbon, "Oceanário de Lisboa is the largest indoor aquarium in Europe and one of the most popular attractions in Lisbon, Portugal. Located in the Parque das Nações district, it showcases a diverse range of marine life from various ecosystems around the world. Visitors can explore different themed exhibits, including the Atlantic Ocean tank, the Indian Ocean tank, and the Pacific Ocean tank, home to a wide variety of fish, sharks, rays, and other aquatic species. Oceanário de Lisboa offers a fascinating and educational experience for visitors of all ages, making it a must-visit destination in Lisbon.", "https://www.oceanario.pt/content/img/artboard_10_6.png");
        Attraction pracaDoComercio = new Attraction("Praça do Comércio (Terreiro do Paço)", lisbon, "Praça do Comércio, also known as Terreiro do Paço, is one of the most iconic squares in Lisbon, Portugal. Situated along the Tagus River in the historic Baixa district, it is characterized by its grand arcades, colorful buildings, and monumental equestrian statue of King José I. Praça do Comércio has served as the commercial and political center of Lisbon for centuries and is surrounded by important landmarks such as the Rua Augusta Arch and the Lisbon City Hall. Visitors can enjoy leisurely walks, outdoor dining, and stunning views of the river and surrounding area from the square.", "https://lp-cms-production.imgix.net/2022-12/GettyImages-533338986.jpeg");
        Attraction miradouroSenhoraDoMonte = new Attraction("Miradouro da Senhora do Monte", lisbon, "Miradouro da Senhora do Monte is one of the highest viewpoints in Lisbon, offering panoramic views of the city and the Tagus River. Located in the Graça neighborhood, it is named after the Chapel of Our Lady of the Mount (Capela de Nossa Senhora do Monte), which sits adjacent to the viewpoint. Visitors can enjoy breathtaking vistas of Lisbon's historic center, including landmarks such as the São Jorge Castle, the Alfama district, and the Ponte 25 de Abril bridge. Miradouro da Senhora do Monte is a popular spot for sunset viewing and photography, providing a peaceful retreat from the bustling streets below.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/2a/b3/f3/bela-cidade.jpg?w=1200&h=-1&s=1");

// Save attraction in the database
        attractionRepository.save(miradouroSenhoraDoMonte);
        attractionRepository.save(pracaDoComercio);
        attractionRepository.save(oceanarioDeLisboa);
        attractionRepository.save(cascais);
        attractionRepository.save(sintra);
        attractionRepository.save(belemTower);

// Attractions in Azores

        Attraction seteCidades = new Attraction("Sete Cidades", azores, "Sete Cidades is a breathtaking volcanic crater located on the island of São Miguel in the Azores archipelago. Known for its stunning twin lakes, one blue and one green, Sete Cidades offers mesmerizing views of the surrounding landscape. Visitors can hike along the crater rim, explore scenic viewpoints, and enjoy outdoor activities such as kayaking and paddleboarding on the lakes. Sete Cidades is a natural wonder and a must-visit destination for travelers exploring São Miguel.", "https://byacores.com/wp-content/uploads/2017/10/IMG_8426.jpg");
        Attraction lagoaDoFogo = new Attraction("Lagoa do Fogo", azores, "Lagoa do Fogo, or Lake of Fire, is a stunning crater lake situated in the center of São Miguel island in the Azores. Surrounded by lush vegetation and volcanic landscapes, the lake is known for its crystal-clear waters and scenic beauty. Visitors can hike along the trails surrounding the lake, swim in its pristine waters, and marvel at the panoramic views from the viewpoints along the way. Lagoa do Fogo is a natural paradise and a must-visit destination for nature lovers and outdoor enthusiasts.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/A%C3%A7ores_lagoa_fogo-0140.tif/lossy-page1-1200px-A%C3%A7ores_lagoa_fogo-0140.tif.jpg");
        Attraction furnas = new Attraction("Furnas", azores, "Furnas is a picturesque town located on the island of São Miguel in the Azores archipelago. Famous for its geothermal hot springs, lush botanical gardens, and volcanic landscapes, Furnas is a popular destination for relaxation and rejuvenation. Visitors can soak in the warm mineral-rich waters of the hot springs, explore the scenic Terra Nostra Botanical Garden, and witness the geothermal activity at the fumaroles and geysers scattered throughout the town. Furnas offers a unique blend of natural beauty and wellness experiences.", "https://www.ecotoursportugal.com/content/uploads/maingallery/crops/5671_mobile_1619169901.jpg");
        Attraction caldeiraVelha = new Attraction("Caldeira Velha", azores, "Caldeira Velha is a natural thermal park located on the island of São Miguel in the Azores archipelago. Nestled amidst lush rainforest vegetation, the park features hot springs, cascading waterfalls, and natural pools filled with warm mineral-rich waters. Visitors can relax in the therapeutic waters, take a dip in the refreshing waterfall pools, and enjoy the tranquil ambiance of the surrounding forest. Caldeira Velha is a hidden gem and a perfect retreat for relaxation and immersion in nature.", "https://parquesnaturais.azores.gov.pt/media/cache/7e/aa/7eaa0e06fcc0e014ef76e94832b47038.jpg");
        Attraction picoMountain = new Attraction("Pico Mountain (Montanha do Pico)", azores, "Pico Mountain, or Montanha do Pico in Portuguese, is the highest peak in Portugal and a UNESCO World Heritage site located on the island of Pico in the Azores archipelago. Rising 2,351 meters above sea level, the mountain offers breathtaking panoramic views of the surrounding islands and the Atlantic Ocean. Visitors can hike to the summit, traverse rugged volcanic landscapes, and explore the unique flora and fauna of the mountain's slopes. Pico Mountain is a paradise for hikers and adventurers seeking epic outdoor experiences.", "https://myazoreshome.com/wp-content/uploads/2020/01/ILHA-DO-PICO-1024x647.jpg");
        Attraction algarDoCarvao = new Attraction("Algar do Carvão", azores, "Algar do Carvão is a fascinating volcanic cave located on the island of Terceira in the Azores archipelago. Formed by ancient volcanic activity, the cave features stunning geological formations, including stalactites, stalagmites, and lava tubes. Visitors can descend into the depths of the cave and explore its otherworldly interior, marveling at the natural beauty and unique rock formations. Algar do Carvão is a geological marvel and a must-visit destination for travelers seeking adventure and exploration in the Azores.", "https://live.staticflickr.com/5694/21493416365_e2341b927f_b.jpg");

// Save attraction in the database
        attractionRepository.save(algarDoCarvao);
        attractionRepository.save(picoMountain);
        attractionRepository.save(furnas);
        attractionRepository.save(caldeiraVelha);
        attractionRepository.save(lagoaDoFogo);
        attractionRepository.save(seteCidades);

//        Attractions in Madeira

        Attraction picoDoArieiro = new Attraction("Pico do Arieiro", madeira, "Pico do Arieiro is the third-highest peak on the island of Madeira, offering stunning panoramic views of the surrounding mountains and coastline. Visitors can reach the summit by car or hiking along well-marked trails, enjoying breathtaking vistas along the way. At the top, there is a viewing platform where travelers can admire the rugged landscape and take in the beauty of the island's rugged terrain. Pico do Arieiro is a popular destination for outdoor enthusiasts and photographers seeking spectacular vistas in Madeira.", "https://upload.wikimedia.org/wikipedia/commons/9/91/Lagoa_das_Sete_Cidades3.jpg");
        Attraction levadaWalks = new Attraction("Levada Walks", madeira, "Madeira is famous for its levadas, irrigation channels that crisscross the island and provide access to some of its most scenic spots. Levada walks offer a unique way to explore Madeira's diverse landscapes, from lush forests to rugged coastlines. Visitors can choose from a variety of trails, ranging from easy strolls to challenging hikes, and discover hidden waterfalls, pristine valleys, and panoramic viewpoints along the way. Levada walks are a must-do activity for nature lovers and outdoor enthusiasts visiting Madeira.", "https://www.journeyera.com/wp-content/uploads/2020/08/LEVADA-DO-MOINHO-TO-LEVADA-NOVA-WATERFALL-HIKE-0772-768x511.jpg");
        Attraction caboGirao = new Attraction("Cabo Girão", madeira, "Cabo Girão is a spectacular sea cliff located on the southern coast of Madeira, offering breathtaking views of the Atlantic Ocean and the surrounding coastline. Rising 580 meters above sea level, it is one of the highest sea cliffs in Europe. Visitors can walk along a glass-floored viewing platform suspended over the edge of the cliff, providing a thrilling experience and panoramic vistas of the ocean below. Cabo Girão is a popular destination for sightseeing and photography, offering unforgettable views of Madeira's dramatic landscape.", "https://lh5.googleusercontent.com/p/AF1QipPDU2usvMEl0BXsKSdGYOcyNlYRvKvi2PsN3P6v=w1080-h624-n-k-no");
        Attraction montePalaceGarden = new Attraction("Monte Palace Tropical Garden (Jardim Tropical Monte Palace)", madeira, "Monte Palace Tropical Garden is a botanical garden located in the hills above Funchal, Madeira's capital city. Spread over 70,000 square meters, it features a diverse collection of exotic plants, tranquil ponds, and striking sculptures from around the world. Visitors can explore themed gardens inspired by different cultures, including Japanese, African, and Madeiran, and enjoy panoramic views of Funchal and the surrounding landscape. Monte Palace Tropical Garden is a serene oasis of beauty and tranquility in Madeira.", "https://montepalace.com/media/sections_gallery/lake-view-720.jpg");
        Attraction kayakPortoSanto = new Attraction("Kayaking in Porto Santo", madeira, "Kayaking in Porto Santo offers a unique way to explore the stunning coastline and crystal-clear waters of this beautiful island. Visitors can rent kayaks from local outfitters and embark on guided tours or self-guided excursions to discover hidden coves, sea caves, and secluded beaches along the island's shoreline. With its calm seas and gentle currents, Porto Santo provides ideal conditions for kayaking adventures for both beginners and experienced paddlers. Whether paddling solo or with a group, kayaking in Porto Santo promises unforgettable experiences and breathtaking views of the island's natural beauty.", "https://sayyestomadeira.com/wp-content/uploads/2020/09/Porto-Santo-Kayak-Tour-and-Rental-23.jpg");
        Attraction scubaDivingFunchal = new Attraction("Scuba Diving in Funchal", madeira, "Scuba diving in Funchal offers an exhilarating opportunity to explore the vibrant underwater world of Madeira's coastline. With its clear waters, abundant marine life, and fascinating rock formations, Funchal is a prime destination for divers of all levels. Visitors can dive along colorful reefs, underwater caves, and shipwrecks, encountering a diverse array of marine species such as colorful fish, octopuses, and moray eels. Guided dives and certification courses are available for beginners, while experienced divers can enjoy deeper dives and more challenging sites. Scuba diving in Funchal promises unforgettable underwater adventures and opportunities for discovery.", "https://s7g10.scene7.com/is/image/flyedelweiss/diving-fnc-header:page-header-teaser-800w?ts=1700049758697&dpr=on,2.625");

// Save attraction in the database
        attractionRepository.save(scubaDivingFunchal);
        attractionRepository.save(montePalaceGarden);
        attractionRepository.save(caboGirao);
        attractionRepository.save(levadaWalks);
        attractionRepository.save(picoDoArieiro);
        attractionRepository.save(kayakPortoSanto);

//        Attractions for Madrid
        Attraction pradoMuseum = new Attraction("Prado Museum (Museo del Prado)", madrid, "The Prado Museum, or Museo del Prado in Spanish, is one of the most important art museums in the world, located in Madrid, Spain. It houses an extensive collection of European art from the 12th to the early 20th century, including works by renowned artists such as Velázquez, Goya, and El Greco. Visitors can admire masterpieces like Velázquez's 'Las Meninas' and Goya's 'The Third of May 1808,' as well as works by other Spanish and European artists. The Prado Museum is a cultural treasure trove and a must-visit destination for art lovers and history enthusiasts.", "https://media.cntraveler.com/photos/580775c2fefb7fe774d64246/16:9/w_2560,c_limit/GettyImages-104515838.jpg");
        Attraction retiroPark = new Attraction("Retiro Park (Parque del Retiro)", madrid, "Retiro Park, or Parque del Retiro in Spanish, is a sprawling green oasis located in the heart of Madrid. Covering 125 hectares, it is one of the city's largest and most popular parks, offering lush gardens, scenic pathways, and recreational areas. Visitors can stroll along tree-lined avenues, rent rowboats on the park's central lake, and relax amidst the park's iconic landmarks, including the Crystal Palace and the Fountain of the Fallen Angel. Retiro Park is a beloved gathering place for locals and tourists alike, providing a tranquil escape from the hustle and bustle of the city.", "https://lp-cms-production.s3.amazonaws.com/public/2020-11/shutterstockRF_226098154.jpg");
        Attraction royalPalaceMadrid = new Attraction("Royal Palace of Madrid (Palacio Real de Madrid)", madrid, "The Royal Palace of Madrid, or Palacio Real de Madrid in Spanish, is the official residence of the Spanish royal family, located in the heart of Madrid. With its grand architecture, opulent interiors, and extensive art collection, it is one of the most impressive palaces in Europe. Visitors can tour the palace's lavishly decorated rooms, including the Throne Room, the Hall of Mirrors, and the Royal Armoury, and admire artworks by renowned artists such as Velázquez, Goya, and Caravaggio. The Royal Palace of Madrid is a symbol of Spain's rich cultural heritage and a must-visit attraction for history buffs and architecture enthusiasts.", "https://travel.usnews.com/images/Martin_Ruegnerbuilding-palace.jpg");
        Attraction bernabeuStadium = new Attraction("Santiago Bernabéu Stadium", madrid, "The Santiago Bernabéu Stadium is one of the most iconic football stadiums in the world, located in Madrid, Spain. Home to the renowned football club Real Madrid, the stadium has a rich history and has hosted numerous memorable matches and events. Visitors can take guided tours of the stadium, exploring its impressive facilities, including the player locker rooms, trophy room, and presidential box. They can also walk through the tunnel onto the pitch, experiencing the stadium from the perspective of the players. The Santiago Bernabéu Stadium is a must-visit destination for football fans, offering an immersive experience into the world of one of the most prestigious football clubs in history.", "https://www.designboom.com/twitterimages/uploads/2020/04/real-madrid-bernabeu-stadium-capacity-designboom-1200.jpg");
        Attraction segoviaHotAirBalloon = new Attraction("Hot Air Balloon Rides in Segovia", madrid, "Hot air balloon rides in Segovia offer a breathtaking way to experience the beauty of this historic Spanish city and its surroundings from a unique perspective. Visitors can soar high above Segovia's iconic landmarks, including the majestic Alcázar fortress and the ancient Roman aqueduct, while enjoying panoramic views of the picturesque countryside and distant mountains. Guided by experienced pilots, hot air balloon flights provide a serene and exhilarating adventure, allowing passengers to float effortlessly through the sky and witness the changing landscapes below. Whether at sunrise or sunset, hot air balloon rides in Segovia promise unforgettable moments and unparalleled vistas of this enchanting region.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/06/6b/81/41.jpg");

// Save attraction in the database
        attractionRepository.save(segoviaHotAirBalloon);
        attractionRepository.save(bernabeuStadium);
        attractionRepository.save(royalPalaceMadrid);
        attractionRepository.save(retiroPark);
        attractionRepository.save(pradoMuseum);

//        Attractions for Barca
        // Create Attraction object for Coastal Path (Camí de Ronda)
        Attraction coastalPath = new Attraction("Coastal Path (Camí de Ronda)", barcelona, "The Coastal Path, or Camí de Ronda, is a scenic hiking trail that stretches along the rugged coastline of Costa Brava, Catalonia. Offering breathtaking views of the Mediterranean Sea, hidden coves, and picturesque fishing villages, the Coastal Path is a paradise for nature lovers and outdoor enthusiasts. Visitors can explore the trail on foot or by bike, winding their way through pine forests, rocky cliffs, and sandy beaches. Along the way, they can discover secluded coves for swimming, enjoy fresh seafood at beachside restaurants, and immerse themselves in the natural beauty of the Mediterranean coast. The Coastal Path is a tranquil escape from the hustle and bustle of city life, providing a rejuvenating experience amidst stunning coastal landscapes.", "https://coastalvillas.com/wp-content/uploads/2017/07/cami-de-ronda.jpg");
        Attraction casaBatllo = new Attraction("Casa Batlló", barcelona, "Casa Batlló is a renowned Modernist building located in the heart of Barcelona's Eixample district. Designed by the architect Antoni Gaudí, the building is known for its striking facade, organic shapes, and colorful mosaic tiles. Visitors can take guided tours of the building, exploring its unique interiors, including the Noble Floor, the Loft, and the Roof Terrace, which offers panoramic views of the city. Casa Batlló is a masterpiece of Catalan Modernism and a testament to Gaudí's innovative architectural vision.", "https://bonjourbarcelone.fr/wp-content/uploads/2017/07/Batllo-3.jpg");
        Attraction montserratMonastery = new Attraction("Montserrat Monastery", barcelona, "The Montserrat Monastery is a Benedictine abbey located in the Montserrat mountain range near Barcelona, Catalonia. Perched atop a rocky cliff at an altitude of over 700 meters, the monastery is renowned for its stunning natural setting, religious significance, and cultural heritage. Visitors can take a scenic cable car or rack railway to reach the monastery, where they can explore its historic buildings, including the basilica, chapels, and museums. The monastery is also home to the famous statue of the Black Madonna, a revered religious icon believed to have miraculous powers. Surrounding the monastery, the Montserrat mountain range offers opportunities for hiking, rock climbing, and enjoying panoramic views of the Catalan countryside. Montserrat Monastery is a spiritual sanctuary and a symbol of Catalonia's religious and cultural identity.", "https://media.patheos.com/~/media/patheos-images/images/sacred-spaces/bulk/48_abbey-of-montserrat-01_credit-unsplash.jpg");
        Attraction parkGuell = new Attraction("Park Güell", barcelona, "Park Güell is a public park located on Carmel Hill in Barcelona, Catalonia. Designed by the renowned architect Antoni Gaudí, the park was originally conceived as a residential housing development but was later transformed into a municipal garden. Park Güell is famous for its colorful mosaic sculptures, whimsical architecture, and stunning panoramic views of the city. Visitors can explore the park's winding pathways, admire the vibrant mosaic designs of the iconic lizard statue and the serpentine bench, and enjoy the tranquility of the surrounding nature. Park Güell is a UNESCO World Heritage Site and one of Barcelona's most popular attractions, attracting millions of visitors each year with its unique blend of art, architecture, and natural beauty.", "https://barcelonando.com/wp-content/uploads/sites/3/2022/04/Park-Guell-free-entrance.jpg");
// Save attraction in the database
        attractionRepository.save(parkGuell);
        attractionRepository.save(montserratMonastery);
        attractionRepository.save(casaBatllo);
        attractionRepository.save(coastalPath);
// Attraction for Malaga

        Attraction caminitoDelRey = new Attraction("Caminito del Rey", malaga, "Caminito del Rey, also known as the King's Little Pathway, is a famous hiking trail located in the province of Malaga, Andalusia. This breathtaking path runs along the steep walls of a narrow gorge carved by the Guadalhorce River, offering stunning views of the surrounding landscape. Originally constructed in the early 20th century as a service route for hydroelectric power plants, Caminito del Rey has since been restored and reopened as a thrilling adventure for hikers and nature enthusiasts. Visitors can traverse the narrow walkways and suspension bridges suspended high above the river, experiencing the thrill of walking through rugged terrain while admiring the natural beauty of the gorge below. Caminito del Rey is a must-visit destination for anyone seeking an unforgettable outdoor adventure in Andalusia.", "https://magazine.deporvillage.net/wp-content/uploads/2024/02/El-Caminito-del-Rey-portada.jpg");
        Attraction nerja = new Attraction("Nerja", malaga, "Nerja is a charming coastal town located in the province of Malaga, Andalusia. Famous for its picturesque beaches, crystal-clear waters, and scenic cliffs, Nerja is a popular destination for beach lovers and outdoor enthusiasts. Visitors can relax on the sandy shores of beaches such as Playa Burriana and Playa de la Calahonda, or explore the stunning sea caves of Nerja, including the famous Cuevas de Nerja. The town's historic center is dotted with whitewashed buildings, narrow streets, and quaint squares, offering a glimpse into traditional Andalusian life. Nerja also boasts a vibrant culinary scene, with numerous restaurants serving fresh seafood and traditional Spanish dishes. Whether it's soaking up the sun on the beach, exploring the town's cultural attractions, or enjoying outdoor activities such as hiking and diving, Nerja has something for everyone to enjoy.", "https://cdn.getyourguide.com/img/tour/4f48cbea6846fdbb.jpeg/97.jpg");
        Attraction alhambraGranada = new Attraction("Alhambra, Granada", malaga, "The Alhambra is a magnificent palace and fortress complex located in Granada, Andalusia. Built during the Moorish rule of Al-Andalus, the Alhambra is renowned for its stunning Islamic architecture, intricate tilework, and lush gardens. Visitors can explore the Nasrid Palaces, the Generalife Gardens, and the Alcazaba fortress, marveling at the beauty and craftsmanship of the Moorish art and design. The Alhambra is a UNESCO World Heritage Site and one of Spain's most iconic cultural landmarks, attracting millions of visitors from around the world each year.", "https://lp-cms-production.imgix.net/2023-08/iStock-1350628212.jpg");
        Attraction alcazabaMalaga = new Attraction("Alcazaba of Malaga", malaga, "The Alcazaba of Malaga is a historic Moorish fortress located in the heart of Malaga, Spain. Built in the 11th century during the Moorish rule of Al-Andalus, the Alcazaba is renowned for its impressive architecture, picturesque gardens, and commanding views of the city and the Mediterranean Sea. Visitors can explore the fortress's well-preserved ramparts, towers, and courtyards, as well as its archaeological museum, which showcases artifacts from the Islamic period. The Alcazaba of Malaga is a cultural landmark that offers insight into the region's rich history and architectural heritage.", "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcQfhMHM3UVDDBoXB3MDV9U5L5OWbnY6tUxbAgiiTs7gHgYodkXbrtQsPgWa-L_48wtislIWkWT2h-Z2BZqSpd3W3F_nr-7WL--5ilLivw");
        Attraction alcazabaAlmeria = new Attraction("Alcazaba of Almería", malaga, "The Alcazaba of Almería is a fortified complex located in the city of Almería, Andalusia. Built in the 10th century by the Moorish rulers of Al-Andalus, the Alcazaba is one of the largest and best-preserved Muslim fortresses in Spain. Visitors can explore the fortress's imposing walls, towers, and courtyards, as well as its archaeological museum, which showcases artifacts from the Islamic period. The Alcazaba of Almería offers panoramic views of the city and the Mediterranean Sea, making it a popular destination for history buffs and photography enthusiasts alike.", "https://www.shutterstock.com/image-photo/alcazaba-almeria-andalusia-spain-600nw-1950745168.jpg");
// Save attraction in the database
        attractionRepository.save(alcazabaAlmeria);
        attractionRepository.save(alcazabaMalaga);
        attractionRepository.save(alhambraGranada);
        attractionRepository.save(nerja);
        attractionRepository.save(caminitoDelRey);


//        Attractions in Berlin
        // Create Attraction object for Brandenburg Gate
        Attraction brandenburgGate = new Attraction("Brandenburg Gate", berlin, "The Brandenburg Gate is an iconic neoclassical monument located in the heart of Berlin, Germany. Built in the late 18th century, the gate has come to symbolize both the division and reunification of Germany. With its impressive columns, grand Doric architecture, and Quadriga sculpture atop, the Brandenburg Gate is a must-visit landmark and a symbol of peace and unity. Visitors can stroll through Pariser Platz, admire the gate from various angles, and learn about its rich history at the nearby information center. The Brandenburg Gate is also a popular venue for cultural events and celebrations throughout the year.", "https://media.cntraveler.com/photos/5b914e80d5806340ca438db1/16:9/w_2560,c_limit/BrandenburgGate_2018_GettyImages-549093677.jpg");
        Attraction museumIsland = new Attraction("Museum Island", berlin, "Museum Island is a UNESCO World Heritage Site located on the northern half of the Spree Island in Berlin. It is home to a complex of five world-renowned museums, including the Altes Museum, the Neues Museum, the Alte Nationalgalerie, the Bode Museum, and the Pergamon Museum. Each museum offers a unique collection of art, artifacts, and historical treasures spanning thousands of years of human history and culture. Visitors can explore ancient Egyptian artifacts, Greek and Roman sculptures, Islamic art, European paintings, and much more. Museum Island is a cultural treasure trove that attracts art lovers, history enthusiasts, and scholars from around the world.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYOjAEJ45EZipnT4iKPwhjkKTI_p0h51tDfA&s");
        Attraction reichstagBuilding = new Attraction("Reichstag Building", berlin, "The Reichstag Building is the seat of the German Bundestag (parliament) and one of Berlin's most iconic landmarks. With its distinctive glass dome and neoclassical facade, the Reichstag is a symbol of democracy and national identity. Visitors can take guided tours of the building, learn about its history and architecture, and climb to the top of the dome for panoramic views of the city. The Reichstag also features exhibitions on German history, politics, and democracy, making it a fascinating destination for visitors interested in government and governance.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLIY3QhEoDoUTmMpnoaqHZIF5CXwacy7imzA&s");

        // Save attraction in the database
        attractionRepository.save(museumIsland);
        attractionRepository.save(reichstagBuilding);
        attractionRepository.save(brandenburgGate);


//      Attractions for Munich
        Attraction zugspitzeMountain = new Attraction("Zugspitze Mountain", munich, "The Zugspitze is the highest peak in Germany, located in the Bavarian Alps near the town of Garmisch-Partenkirchen. Standing at 2,962 meters above sea level, it offers breathtaking panoramic views of the surrounding alpine landscape and beyond. Visitors can reach the summit by taking the Zugspitze Railway, Germany's highest cogwheel railway, or by hiking one of the mountain trails. At the summit, there are observation platforms, restaurants, and even a glacier for skiing and snowboarding year-round. The Zugspitze offers outdoor enthusiasts the opportunity to experience the beauty and majesty of the Alps in both summer and winter.", "https://zugspitze.de/Bilder/Zugspitze/Winter/Gipfel%26Pano/293/image-thumb__293__lightbox/MF_2019_0501_BZB_0023.f5c0cf3c.jpg");
        Attraction englishGarden = new Attraction("English Garden", munich, "The English Garden is a vast public park in the heart of Munich, Germany, spanning over 900 acres. Designed in the style of an English landscape garden, it offers scenic walking and cycling paths, lush greenery, and serene lakes and streams. Visitors can relax in the shade of centuries-old trees, enjoy a picnic by the water, or watch surfers riding the standing wave on the Eisbach River. The English Garden is also home to beer gardens, outdoor cafes, and traditional Bavarian beer halls, providing plenty of opportunities to unwind and enjoy the outdoors.", "https://hips.hearstapps.com/hmg-prod/images/english-gardens-1582212436.jpg?crop=1.00xw:1.00xh;0,0&resize=640:*");
        Attraction nymphenburgPalace = new Attraction("Nymphenburg Palace", munich, "Nymphenburg Palace is a magnificent Baroque palace located in Munich, Germany. Built as a summer residence for the Bavarian rulers, it boasts stunning architecture, landscaped gardens, and opulent interiors. Visitors can explore the palace's lavish rooms, including the Gallery of Beauties, the Porcelain Cabinet, and the Grand Hall, as well as stroll through the sprawling palace gardens, which feature fountains, sculptures, and a charming pagoda. Nymphenburg Palace is a cultural treasure that offers a glimpse into Bavaria's royal past and is a must-visit attraction in Munich.", "https://citytourcard-muenchen.com/media/pages/partner/schloss-nymphenburg/2074396873-1693428301/schloss-nymphenburg.jpg");

        // Save attraction in the database
        attractionRepository.save(nymphenburgPalace);
        attractionRepository.save(englishGarden);
        attractionRepository.save(zugspitzeMountain);


//        Attractions in Istanbul

        Attraction grandBazaar = new Attraction("Grand Bazaar (Kapalı Çarşı)", istanbul, "The Grand Bazaar, or Kapalı Çarşı, is one of the world's largest and oldest covered markets, with over 4,000 shops spread across 61 streets. Dating back to the 15th century, it is a vibrant hub of commerce and culture, where visitors can find everything from jewelry and textiles to spices and souvenirs. Navigating the maze-like bazaar is an experience in itself, with its bustling alleys, colorful displays, and friendly vendors. Whether you're shopping for gifts or simply soaking up the atmosphere, the Grand Bazaar is a must-visit destination in Istanbul.", "https://media1.thrillophilia.com/filestore/m7zk9xl547kgk41c6rue2he8h124_1587211169_fi.jpg?w=400&dpr=2");
        Attraction bosphorusCruise = new Attraction("Bosphorus Cruise", istanbul, "A Bosphorus Cruise is a scenic boat tour along the Bosphorus Strait, which divides the city of Istanbul into two continents, Europe and Asia. It offers breathtaking views of the city's skyline, historic landmarks, and waterfront mansions, as well as an opportunity to see the iconic bridges that span the strait. Visitors can choose from a variety of cruise options, including daytime sightseeing tours, sunset cruises, and dinner cruises with live entertainment. A Bosphorus Cruise provides a unique perspective of Istanbul and is a memorable way to experience the beauty of the city.", "https://mediaim.expedia.com/localexpert/964719/8db9426d-a6b2-4515-8e29-226033cd14ef.jpg?impolicy=resizecrop&rw=1005&rh=565");
        Attraction buyukada = new Attraction("Büyükada (Princess Island)", istanbul, "Büyükada, also known as Princess Island, is the largest of the Princes' Islands in the Sea of Marmara, just off the coast of Istanbul. Renowned for its tranquil atmosphere, scenic landscapes, and charming Victorian-era architecture, Büyükada offers a peaceful retreat from the hustle and bustle of city life. Visitors can explore the island's picturesque streets by horse-drawn carriage or bicycle, visit historic landmarks such as the Aya Yorgi Church and Monastery, and relax on its pristine beaches. Büyükada is a popular day trip destination for locals and tourists alike, offering a perfect blend of natural beauty and old-world charm.", "https://idsb.tmgrup.com.tr/ly/uploads/images/2023/08/09/286374.jpg");
        Attraction sapancaLake = new Attraction("Sapanca Lake", istanbul, "Sapanca Lake is a serene freshwater lake located in the Sakarya Province of Turkey, near the town of Sapanca. Surrounded by lush greenery and rolling hills, the lake offers breathtaking views and a tranquil atmosphere, making it a popular destination for nature lovers and outdoor enthusiasts. Visitors can enjoy a variety of activities on and around the lake, including boating, fishing, picnicking, and hiking along scenic trails. The area is also home to charming villages, boutique hotels, and cozy cafes, providing plenty of opportunities for relaxation and exploration. Whether you're seeking adventure or simply want to unwind amidst natural beauty, Sapanca Lake offers an idyllic escape from the hustle and bustle of city life.", "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSjI0ILKeECJhenl8UqWlftVNKmBz-toMmqnW2e7lAN3Vwwq0tFyL1g3VOFI0q-DekoHSPkghapmjzqlF2lxpu9Nb6ah0tLcehAHPBudQ");
// Save attraction in the database
        attractionRepository.save(sapancaLake);
        attractionRepository.save(buyukada);
        attractionRepository.save(bosphorusCruise);
        attractionRepository.save(grandBazaar);

//        Attractions in Cappadocia
        // Create Attraction object for Göreme Open-Air Museum
        Attraction goremeMuseum = new Attraction("Göreme Open-Air Museum", cappadocia, "The Göreme Open-Air Museum is a UNESCO World Heritage Site located in the town of Göreme, Cappadocia. It features a complex of rock-cut churches and monasteries dating back to the Byzantine period. Visitors can explore the intricately decorated interiors of these ancient cave dwellings, which contain stunning frescoes depicting scenes from the life of Jesus Christ and other biblical figures. The museum offers a fascinating glimpse into the region's rich religious and cultural history, making it a must-visit attraction for anyone exploring Cappadocia.", "https://toursce.com/destinations/wp-content/uploads/2018/07/Goreme-Open-Air-Museum-Cappadocia-4.jpg");
        Attraction hotAirBalloon = new Attraction("Hot Air Balloon Ride", cappadocia, "A hot air balloon ride over the surreal landscapes of Cappadocia is a once-in-a-lifetime experience. Visitors can soar above the fairy chimney rock formations, valleys, and vineyards as the sun rises, providing breathtaking panoramic views of the region's unique terrain. Many tour operators offer hot air balloon flights, allowing travelers to witness the stunning beauty of Cappadocia from above and create unforgettable memories.", "https://www.travelandleisure.com/thmb/MbwHC-LaxhJsfeBEBVAYCBrg5wY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/hot-air-balloons-festival-cappadocia-turkey-HOTAIR0605-6d61318b9ac0462d9d20f387e5c7d1a9.jpg");
        Attraction quadBiking = new Attraction("Sunset Quad Biking in Cappadocia", cappadocia, "Sunset quad biking in Cappadocia offers an exhilarating way to explore the region's stunning landscapes and fairy chimney formations. Visitors can embark on guided quad biking tours that traverse rugged trails, ancient valleys, and scenic viewpoints, all while enjoying the breathtaking colors of the sunset casting a golden glow over the surreal terrain. With the wind in your hair and the sun setting on the horizon, sunset quad biking in Cappadocia promises an unforgettable adventure and unparalleled views of one of Turkey's most iconic destinations.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/07/a8/e4/5e.jpg");
        // Save attraction in the database
        attractionRepository.save(hotAirBalloon);
        attractionRepository.save(goremeMuseum);
        attractionRepository.save(quadBiking);


//Attractions in Antalya
        // Create Attraction object for Konyaaltı Beach
        Attraction konyaaltiBeach = new Attraction("Konyaaltı Beach", antalya, "Konyaaltı Beach is a popular seaside destination located west of Antalya's city center. Stretching for several kilometers along the Mediterranean coastline, it features pristine sandy shores, turquoise waters, and stunning views of the surrounding mountains. Visitors can relax on the beach, swim in the crystal-clear sea, or participate in water sports such as snorkeling, jet skiing, and parasailing. The beach is also lined with cafes, restaurants, and bars, offering a variety of dining and entertainment options. Whether you're seeking sun and relaxation or adventure and excitement, Konyaaltı Beach has something for everyone.", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Falezlerden_Antalya_Konyaalt%C4%B1_Plaj%C4%B1na_do%C4%9Fru_bir_g%C3%B6r%C3%BCn%C3%BCm.jpg/640px-Falezlerden_Antalya_Konyaalt%C4%B1_Plaj%C4%B1na_do%C4%9Fru_bir_g%C3%B6r%C3%BCn%C3%BCm.jpg");
        Attraction oldTown = new Attraction("Antalya Old Town (Kaleiçi)", antalya, "Antalya Old Town, also known as Kaleiçi, is a charming historic district located within the ancient city walls of Antalya. It is characterized by narrow cobblestone streets, Ottoman-era architecture, and picturesque harbor views. Visitors can wander through the maze-like alleys, explore ancient landmarks such as Hadrian's Gate and the Yivli Minare Mosque, and browse boutique shops selling traditional handicrafts and souvenirs. Kaleiçi is also home to a vibrant dining scene, with cozy cafes, rooftop restaurants, and waterfront tavernas serving delicious Turkish cuisine. Exploring Antalya Old Town is like stepping back in time, offering a glimpse into the city's rich history and cultural heritage.", "https://www.planetjanettravels.com/wp-content/uploads/2017/09/12_Turkey-Antalya-old-harbor.jpg");
        Attraction landOfLegends = new Attraction("The Land of Legends Theme Park", antalya, "The Land of Legends Theme Park is a world-class entertainment complex located in Belek, near Antalya. It offers a wide range of attractions and activities for visitors of all ages, including thrilling rides, water slides, and interactive experiences. The park features themed zones such as Adventure, Waterfront Kingdom, and Legends Avenue, as well as a shopping and dining district. Highlights include the Typhoon Coaster, the Deep Dive immersive aquarium, and the Mythical Creatures Island. The Land of Legends Theme Park promises an unforgettable day of fun and excitement for the whole family.", "https://content.tui.co.uk/adamtui/2023_10/10_9/6a0091f7-1609-440b-9ed1-b097009c73f3/ACC_975418_TUR_115_AQUAWebOriginalCompressed.jpg?i10c=img.resize(width:658);img.crop(width:658%2Cheight:370)");
        Attraction horseRiding = new Attraction("Horse Riding Adventure", antalya, "Experience the beauty of Antalya's countryside on a thrilling horse riding adventure. Guided tours are available for riders of all skill levels, allowing you to explore scenic trails, lush forests, and picturesque valleys on horseback. Whether you're a beginner or an experienced rider, horse riding in Antalya offers a unique and memorable way to connect with nature and enjoy the tranquility of the Turkish countryside.", "https://www.touralanya.com/TurResimleri/024156horseridinginantalya.jpeg");
        Attraction jetSkiing = new Attraction("Jet Skiing Adventure", antalya, "Experience the thrill of jet skiing on the crystal-clear waters of the Mediterranean Sea in Antalya. Jet ski rentals are available at various beaches and marinas along the coast, allowing you to explore the coastline at your own pace and enjoy the freedom of riding the waves. Whether you're a beginner or an experienced jet skier, Antalya offers ideal conditions for an exhilarating aquatic adventure.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/38/84/50/caption.jpg?w=500&h=400&s=1");
        Attraction kursunluPark = new Attraction("Kurşunlu Waterfall Nature Park", antalya, "Kurşunlu Waterfall Nature Park is a tranquil oasis located approximately 19 kilometers northeast of Antalya city center. It is characterized by lush greenery, meandering streams, and a series of cascading waterfalls. Visitors can follow scenic walking trails through the park, passing by dense forests, rock formations, and picnic areas along the way. The highlight of the park is the stunning Kurşunlu Waterfall, which plunges into a natural pool surrounded by ferns and moss-covered rocks. Kurşunlu Waterfall Nature Park is a peaceful retreat where visitors can reconnect with nature and enjoy the sights and sounds of the Turkish countryside.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/13/78/f1/87/20180519-152211-largejpg.jpg?w=1200&h=-1&s=1");
// Save attraction in the database
        attractionRepository.save(kursunluPark);
        attractionRepository.save(jetSkiing);
        attractionRepository.save(horseRiding);
        attractionRepository.save(landOfLegends);
        attractionRepository.save(oldTown);
        attractionRepository.save(konyaaltiBeach);

// Attractions for Vienna


        Attraction hallstattDayTrip = new Attraction("Hallstatt Day Trip from Vienna", vienna, "Embark on a scenic day trip from Vienna to the picturesque village of Hallstatt, nestled in the Austrian Alps. Situated on the shores of Lake Hallstatt and surrounded by towering mountains, Hallstatt is renowned for its breathtaking natural beauty, charming architecture, and rich cultural heritage. The journey from Vienna to Hallstatt takes approximately 3-4 hours by train or car, passing through stunning alpine landscapes along the way. Once in Hallstatt, visitors can explore the village's historic streets, visit the iconic Hallstatt Skywalk for panoramic views of the lake and mountains, and learn about the region's salt mining history at the Salt Mine Museum. With its idyllic setting and old-world charm, Hallstatt is a must-visit destination for travelers seeking a day of exploration and relaxation amidst stunning alpine scenery.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/a3/bb/75/caption.jpg?w=500&h=400&s=1");
        Attraction schonbrunnAttraction = new Attraction("Schönbrunn Palace", vienna, "Schönbrunn Palace is a UNESCO World Heritage Site and one of Vienna's most iconic landmarks. This Baroque palace served as the summer residence of the Habsburg monarchs and is renowned for its stunning architecture, extensive gardens, and rich history. Visitors can explore the opulent rooms of the palace, stroll through the meticulously landscaped gardens, and enjoy panoramic views of the city from the Gloriette. Schönbrunn Palace offers a fascinating glimpse into the grandeur and splendor of Austria's imperial past.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/07/3a/91/71.jpg");
        Attraction danubeValleyAttraction = new Attraction("Danube Valley", vienna, "The Danube Valley, or Donauvalley, is a scenic region along the Danube River known for its stunning landscapes, charming villages, and historic landmarks. Stretching from the Wachau Valley to the Iron Gate, the Danube Valley offers a wealth of outdoor activities and cultural attractions for visitors to enjoy. Highlights of the region include the medieval town of Dürnstein, famous for its hilltop castle and vineyards; the baroque abbey of Melk, a UNESCO World Heritage Site; and the picturesque village of Grein, home to Austria's oldest theater. Visitors can explore the Danube Valley by boat, bike, or car, stopping to admire the breathtaking scenery, visit charming villages, and sample regional cuisine along the way.", "https://lp-cms-production.imgix.net/2021-02/shutterstockRF_144233116.jpg");
// Save attraction in the database
        attractionRepository.save(danubeValleyAttraction);
        attractionRepository.save(schonbrunnAttraction);
        attractionRepository.save(hallstattDayTrip);

//        Attraction for Innsbruck

        Attraction nordketteMountains = new Attraction("Nordkette Mountain Range", innsbruck, "The Nordkette is a dramatic mountain range located just north of Innsbruck, Austria. It is part of the larger Karwendel Nature Park and offers spectacular alpine scenery and outdoor recreational opportunities year-round. Visitors can take the Nordkette Cable Car (Hungerburgbahn) from the city center to the Seegrube and Hafelekar stations, where they can enjoy panoramic views of the surrounding mountains and valleys. The Nordkette is a popular destination for hiking, mountain biking, skiing, and snowboarding, with trails and slopes suitable for all skill levels. Whether you're seeking adventure or simply want to admire the natural beauty of the Austrian Alps, the Nordkette Mountain Range has something for everyone.", "https://cdn-blob.austria.info/cms-uploads-prod/default/0001/11/thumb_10738_default_teaser.jpeg?cachebuster=1714387339");
        Attraction swarovskiCrystalWorlds = new Attraction("Swarovski Crystal Worlds", innsbruck, "Swarovski Crystal Worlds, or Kristallwelten, is an enchanting art installation and museum located in Wattens, near Innsbruck, Austria. Created by the renowned crystal manufacturer Swarovski, the attraction features stunning crystal artworks, interactive exhibits, and beautifully landscaped gardens. Visitors can explore the Crystal Worlds Chamber of Wonder, a subterranean space filled with dazzling crystal creations by international artists, as well as outdoor installations such as the Crystal Cloud and the Giant's Garden. Swarovski Crystal Worlds offers a magical experience for visitors of all ages, blending art, design, and nature in a unique and immersive setting.", "https://www.tyrol.tl/images/cms/main/754x435/B_2010_004_1270112308.jpg");
// Save attraction in the database
        attractionRepository.save(swarovskiCrystalWorlds);
        attractionRepository.save(nordketteMountains);

        // Attractions for cities in Belgium

        //Brussels

        Attraction grandPlace = new Attraction("Grand Place", brussels, "The Grand Place is a UNESCO World Heritage Site and the central square of Brussels. It is surrounded by opulent guildhalls and the stunning Brussels City Hall. The square is a hub of activity, hosting events, markets, and festivals throughout the year. Visitors can admire the magnificent architecture, enjoy a Belgian waffle from one of the nearby vendors, or simply soak in the vibrant atmosphere.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Grand-Place%2C_Brussels_-_panorama%2C_June_2018.jpg/800px-Grand-Place%2C_Brussels_-_panorama%2C_June_2018.jpg");
        Attraction atomium = new Attraction("Atomium", brussels, "The Atomium is an iconic symbol of Brussels, representing an iron crystal magnified 165 billion times. It was originally built for the 1958 Brussels World's Fair and has since become a major tourist attraction. Visitors can explore the spheres, which house exhibitions on science, technology, and design, and enjoy panoramic views of the city from the top sphere.", "https://atomium.be/Content/Images/Atomium_Style.html.jpg");
        Attraction royalPalace = new Attraction("Royal Palace of Brussels", brussels, "The Royal Palace of Brussels serves as the official residence of the King and Queen of the Belgians, although it is only used for state ceremonies and official receptions. Visitors can tour the palace during the summer months when it is open to the public. The interior is adorned with magnificent decorations, exquisite furnishings, and works of art, offering a glimpse into Belgium's royal heritage.", "https://agendabrussels2.imgix.net/8abb9d5db096b1eccc63f57fb197424f23e71062.jpg");
        Attraction miniEurope = new Attraction("Mini-Europe", brussels, "Mini-Europe is a miniature park located at the foot of the Atomium, featuring replicas of famous landmarks from across Europe at a scale of 1:25. Visitors can wander through the park and marvel at miniature versions of the Eiffel Tower, the Colosseum, and other iconic sites. Interactive exhibits provide insight into the history and culture of each destination.", "https://www.minieurope.com/wp-content/uploads/2023/03/panoramic20141-scaled.jpg");
        Attraction autoWorld = new Attraction("Auto World", brussels, "Auto World is a fascinating museum dedicated to the history of automobiles, located in the beautiful Cinquantenaire Park. The museum boasts an extensive collection of vintage cars, ranging from early horseless carriages to classic sports cars and luxury vehicles. Visitors can explore the evolution of automotive design and technology through interactive exhibits, multimedia displays, and meticulously restored automobiles. Whether you're a car enthusiast or simply curious about the history of transportation, Auto World offers a captivating journey through the world of automobiles.", "https://upload.wikimedia.org/wikipedia/commons/c/c2/Blue_Boulevard_2.jpg");


// Save attraction in the database
        attractionRepository.save(grandPlace);
        attractionRepository.save(atomium);
        attractionRepository.save(royalPalace);
        attractionRepository.save(miniEurope);
        attractionRepository.save(autoWorld);


//Antwerp


        Attraction antwerpCentralStation = new Attraction("Antwerp Central Station", antwerp, "Antwerp Central Station is often referred to as the 'Railway Cathedral' due to its stunning architecture and grandeur. It is one of the most beautiful train stations in the world, featuring a blend of Art Nouveau and Neo-Gothic styles. Visitors can admire the impressive dome, intricate detailing, and spacious concourse, or simply marvel at the bustling activity of trains and passengers.", "https://media.worldofinteriors.com/photos/63624619873e80c95ba2e586/3:2/w_2046,h_1364,c_limit/Antwerpen-Centraal_Luc%20Mercelis.jpg");
        Attraction antwerpZoo = new Attraction("Antwerp Zoo", antwerp, "Antwerp Zoo is one of the oldest and largest zoos in the world, dating back to 1843. It is home to a diverse collection of animals, including elephants, giraffes, lions, and penguins. Visitors can explore various habitats, attend animal feedings and demonstrations, or relax in the tranquil surroundings of the zoo's botanical garden.", "https://mediaim.expedia.com/localexpert/47089016/056be4db-c1a1-43c7-b87e-93f2c734f084.jpg?impolicy=resizecrop&rw=1005&rh=565");
        Attraction diamondDistrict = new Attraction("Antwerp Diamond District", antwerp, "The Antwerp Diamond District is renowned as the diamond capital of the world, with approximately 80% of the world's rough diamonds and 50% of cut diamonds passing through its streets. Visitors can stroll through the district's diamond shops, learn about the diamond trade's history and significance, and even purchase their own precious gemstones.", "https://gem-a.com/wp-content/uploads/2018/07/An-Afternoon-in-Antwerps-Historic-Diamond-District.jpeg");
        Attraction masMuseum = new Attraction("Museum aan de Stroom (MAS)", antwerp, "The Museum aan de Stroom, or MAS, is a striking museum located on the banks of the River Scheldt. It showcases the city's rich cultural heritage and maritime history through a diverse collection of artifacts, artworks, and interactive exhibits. Visitors can enjoy panoramic views of Antwerp from the museum's rooftop terrace or explore its engaging displays on topics ranging from global trade to local traditions.", "https://cdn.mos.cms.futurecdn.net/4GzoqYXNFcF2M2S6nFcg5K-1200-80.jpg");
        Attraction rubensHouse = new Attraction("Rubenshuis (Rubens' House)", antwerp, "Rubenshuis, or Rubens' House, is the former residence and studio of the renowned Flemish Baroque painter Peter Paul Rubens. It now operates as a museum dedicated to his life and work. Visitors can explore the beautifully preserved rooms, admire Rubens' masterpieces, and learn about his artistic techniques and influences. The museum also features a garden designed in the style of Rubens' era, providing a tranquil retreat in the heart of Antwerp.", "https://www.gpsmycity.com/img/gd_sight/33149.jpg");


// Save attraction in the database
        attractionRepository.save(antwerpCentralStation);
        attractionRepository.save(antwerpZoo);
        attractionRepository.save(diamondDistrict);
        attractionRepository.save(masMuseum);
        attractionRepository.save(rubensHouse);


//Ghent


        Attraction gravensteenCastle = new Attraction("Gravensteen Castle", ghent, "Gravensteen Castle, also known as the Castle of the Counts, is a medieval fortress located in the heart of Ghent. It dates back to the 12th century and offers visitors a glimpse into the city's rich history. Explore the castle's imposing walls, towers, and dungeons, and learn about its role in medieval life through interactive exhibits and guided tours.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/39/8e/90.jpg");
        Attraction ghentAltarpiece = new Attraction("Ghent Altarpiece", ghent, "The Ghent Altarpiece, also known as the Adoration of the Mystic Lamb, is a renowned masterpiece of Renaissance art created by the Van Eyck brothers. It is housed in Saint Bavo's Cathedral and is considered one of the most important works of Western art. Visitors can admire the altarpiece's intricate panels, rich symbolism, and exceptional craftsmanship.", "https://www.visitflanders.com/sites/default/files/styles/header_background_lg/public/media/images/2022-11/lam-gods.jpg?h=97baae05&itok=Sh5lplp3");
        Attraction ghentCanals = new Attraction("Ghent Canals", ghent, "Ghent's picturesque canals offer visitors a scenic way to explore the city's historic center. Take a boat tour along the waterways, passing by charming medieval buildings, picturesque bridges, and waterfront cafés. Learn about Ghent's maritime history and architectural landmarks while enjoying a leisurely cruise through the heart of the city.", "https://visit.gent.be/sites/default/files/styles/index_mobile/public/media/img/2023-11/incredible-views.jpg?itok=eAMBCJO-");
        Attraction stBavosAbbey = new Attraction("St. Bavo's Abbey", ghent, "St. Bavo's Abbey is a historic abbey located on the outskirts of Ghent. Founded in the 7th century, it played a significant role in the religious and cultural life of the region. Visitors can explore the abbey's tranquil grounds, visit its museum and art gallery, and learn about its fascinating history through exhibitions and guided tours.", "https://visit.gent.be/sites/default/files/styles/photo_large/public/media/img/2022-08/VisitReeks108-DT011300.jpg?itok=As1uSRw9");

// Save attraction in database

        attractionRepository.save(gravensteenCastle);
        attractionRepository.save(ghentAltarpiece);
        attractionRepository.save(ghentCanals);
        attractionRepository.save(stBavosAbbey);


//brugges


        Attraction belfryOfBruges = new Attraction("Belfry of Bruges", bruges, "The Belfry of Bruges is a medieval bell tower located in the heart of the city. It offers panoramic views of Bruges and the surrounding area from its 83-meter-high tower. Visitors can climb the 366 steps to the top for breathtaking vistas of the city's historic center and picturesque landscape.", "https://www.museabrugge.be/volumes/general/_1200x630_crop_center-center_82_none/Belfort-met-panorama22_Musea-Brugge.f1664971276.jpg?mtime=1664971276");
        Attraction minnewaterPark = new Attraction("Minnewater Park", bruges, "Minnewater Park, also known as the 'Lake of Love,' is a tranquil oasis located in the southern part of Bruges. It features a picturesque lake surrounded by trees, walking paths, and gardens. Visitors can enjoy a leisurely stroll, relax by the water's edge, or feed the swans that inhabit the area.", "https://www.visitbruges.be/sites/default/files/styles/card_vertical_600x450_/public/media/tdms/5/card/200723_jan5377-jandarthet.jpg.webp?itok=fFjh0D8V");
        Attraction begijnhof = new Attraction("Begijnhof", bruges, "The Begijnhof is a tranquil enclave in the heart of Bruges, originally founded in the 13th century as a religious community for laywomen. It consists of quaint white houses, a central green courtyard, and a small chapel. Visitors can explore the peaceful surroundings, learn about the history of the Beguines, and admire the well-preserved architecture.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTRPUjhsfSsl6XwsMx9EAsGVRT3CxLHMkdbQ&s");
        Attraction brugesCanals = new Attraction("Bruges Canals", bruges, "The canals of Bruges are a network of waterways that wind their way through the city's medieval streets and historic landmarks. Visitors can take a boat tour along the canals to discover Bruges from a unique perspective, passing by charming bridges, old warehouses, and picturesque gabled houses.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/39/7a/e6.jpg");
        Attraction chocolaterieDepla = new Attraction("Chocolaterie Depla", bruges, "Chocolaterie Depla is a family-owned chocolate shop located in the heart of Bruges. It offers a wide range of handmade chocolates, pralines, and truffles, crafted using traditional Belgian techniques and high-quality ingredients. Visitors can take a guided tour of the chocolate-making process, sample delicious treats, and purchase souvenirs to take home.", "https://i.dailymail.co.uk/i/newpix/2018/06/07/17/4D053B1900000578-5817343-image-m-157_1528388027575.jpg");

        attractionRepository.save(belfryOfBruges);
        attractionRepository.save(minnewaterPark);
        attractionRepository.save(begijnhof);
        attractionRepository.save(brugesCanals);
        attractionRepository.save(chocolaterieDepla);


//liege



        Attraction citadelOfLiege = new Attraction("Citadel of Liège", liege, "The Citadel of Liège is a historic fortress located on a hill overlooking the city. It dates back to the 10th century and has played a significant role in the defense of Liège over the centuries. Visitors can explore the fortress's ramparts, bastions, and underground tunnels, and enjoy panoramic views of the city and surrounding landscape.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSA6t0OBBtWInXN7QHpjnBUkFfAy6VyiDuBFw&s");
        Attraction laBoverie = new Attraction("La Boverie", liege, "La Boverie is an art museum located in a beautiful 19th-century building on the banks of the River Meuse. It houses a diverse collection of artworks, ranging from Old Masters to contemporary pieces. Visitors can admire paintings, sculptures, and decorative arts from various periods and styles, and explore temporary exhibitions highlighting different aspects of the art world.", "https://www.visitezliege.be/Photos/Plage450To1000/anx-0r-008x-0002.jpg");
        Attraction montagneDeBueren = new Attraction("Montagne de Bueren", liege, "Montagne de Bueren is a famous staircase in Liège, consisting of 374 steps that ascend a steep hillside. It is one of the city's most iconic landmarks and offers a challenging yet rewarding climb for visitors. At the top, you'll be rewarded with stunning views of Liège and the surrounding area, making it a popular spot for photographers and fitness enthusiasts alike.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/34/d2/04/photo0jpg.jpg?w=1200&h=-1&s=1");
        Attraction curtiusMuseum = new Attraction("Curtius Museum", liege, "The Curtius Museum is a fascinating museum housed in a series of historic buildings along the River Meuse. It showcases the art and history of Liège, with collections ranging from ancient artifacts to decorative arts and fine arts. Visitors can explore exhibits on archaeology, medieval life, and the industrial revolution, providing insights into the city's rich cultural heritage.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/7f/63/10/musee-curtius-curtius.jpg?w=1200&h=-1&s=1");
        Attraction parcDeLaBoverie = new Attraction("Parc de la Boverie", liege, "Parc de la Boverie is a beautiful park located on an island in the River Meuse, adjacent to the La Boverie museum. It features lush greenery, scenic walking paths, and picturesque views of the river. Visitors can enjoy leisurely strolls, picnics by the water, or simply relax in the peaceful surroundings of this urban oasis.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/5b/eb/1c/le-musee.jpg?w=1200&h=1200&s=1");

        // Save attraction in database

        attractionRepository.save(citadelOfLiege);
        attractionRepository.save(laBoverie);
        attractionRepository.save(montagneDeBueren);
        attractionRepository.save(curtiusMuseum);
        attractionRepository.save(parcDeLaBoverie);


        //Attractions for cities in Netherlands

        //amsterdam


        Attraction vanGoghMuseum = new Attraction("Van Gogh Museum", amsterdam, "The Van Gogh Museum is dedicated to the life and work of the Dutch artist Vincent van Gogh. It houses the largest collection of his paintings and drawings in the world, including iconic masterpieces such as 'Sunflowers' and 'The Bedroom.' Visitors can explore van Gogh's artistic evolution, learn about his turbulent life, and appreciate his contributions to the art world.", "https://th-thumbnailer.cdn-si-edu.com/GWxauDhOnh2nGYaZnvX9CP2cZgo=/fit-in/1600x0/filters:focal(2409x1653:2410x1654)/https://tf-cmsv2-smithsonianmag-media.s3.amazonaws.com/filer/f3/fa/f3fa8097-4f45-4555-96de-a6cc736e6587/van_gogh_angle1_starry_night_300dpi.jpg");
        Attraction anneFrankHouse = new Attraction("Anne Frank House", amsterdam, "The Anne Frank House is a museum dedicated to the Jewish wartime diarist Anne Frank, who hid from Nazi persecution with her family during World War II. The museum is located in the actual house where the Frank family lived in hiding for over two years. Visitors can tour the secret annex, see Anne's original diary, and learn about the Holocaust and its impact on Anne's life and legacy.", "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/504000/504193-anne-frank-house.jpg");
        Attraction rijksmuseum = new Attraction("Rijksmuseum", amsterdam, "The Rijksmuseum is the national museum of the Netherlands, showcasing Dutch art and history from the Middle Ages to the present day. It houses a vast collection of masterpieces, including works by Rembrandt, Vermeer, and Van Gogh. Visitors can admire paintings, sculptures, decorative arts, and historical artifacts, providing insights into Dutch culture and heritage.", "https://www.rijksmuseum.nl/assets/fdd2733b-030d-46be-ac53-932f3b719e77?w=1920&h=1080&fx=3333&fy=2025&c=c454422478deb97d5028ef15fe8ee1444efc831752f549ed9579f8f86f2b6708");
        Attraction canalCruise = new Attraction("Canal Cruise", amsterdam, "A canal cruise is a popular way to explore Amsterdam's picturesque waterways and historic landmarks. Visitors can hop aboard a boat and enjoy a leisurely tour of the city's canals, passing by iconic sights such as the Anne Frank House, Westerkerk, and Skinny Bridge. Along the way, you'll learn about Amsterdam's rich history, architecture, and culture from informative guides.", "https://www.blueboat.nl/wp-content/uploads/2021/08/CCC_main-2.jpg");
        Attraction vondelpark = new Attraction("Vondelpark", amsterdam, "Vondelpark is Amsterdam's most famous park, spanning over 47 hectares of greenery in the heart of the city. It offers a peaceful retreat from the hustle and bustle of urban life, with winding paths, ponds, gardens, and open lawns. Visitors can enjoy leisurely walks, picnics, cycling, or simply relax and soak up the natural beauty of this beloved Amsterdam landmark.", "https://upload.wikimedia.org/wikipedia/commons/3/3b/Amsterdam%2C_Vondelpark%2C_at_the_pond-2.jpg");


        // Save attraction in database

        attractionRepository.save(vanGoghMuseum);
        attractionRepository.save(anneFrankHouse);
        attractionRepository.save(rijksmuseum);
        attractionRepository.save(canalCruise);
        attractionRepository.save(vondelpark);

        //rotterdam



        Attraction rotterdamMarkthal = new Attraction("Rotterdam Markthal", rotterdam, "The Rotterdam Markthal is a modern indoor market located in the heart of the city. It is known for its striking horseshoe-shaped architecture and vibrant atmosphere. Visitors can explore a wide variety of food stalls, selling fresh produce, gourmet delicacies, and international cuisine. The ceiling of the Markthal is adorned with a colorful mural, making it a feast for the eyes as well as the palate.", "https://images.adsttc.com/media/images/5431/b11e/c07a/8054/8f00/05c2/large_jpg/-%C2%AEProvast__MVRDV__foto_Daria_Scagliola_Stijn_Brakkee__18.jpg?1412542722");
        Attraction ssRotterdam = new Attraction("SS Rotterdam", rotterdam, "The SS Rotterdam is a former ocean liner and cruise ship, now permanently moored in Rotterdam as a hotel and museum. Visitors can tour the ship's decks, cabins, and public areas, learning about its history and maritime heritage. The SS Rotterdam offers a unique glimpse into the golden age of ocean travel, with exhibits, artifacts, and interactive displays showcasing life onboard a luxury liner.", "https://ssrotterdam.com/wp-content/uploads/sites/2/2021/04/ssRotterdam_Schip_Avond_-1280x600_-Mark-de-Rooij-13_4716168_8984459_2627966.jpg");
        Attraction euromast = new Attraction("Euromast", rotterdam, "The Euromast is an iconic observation tower in Rotterdam, offering panoramic views of the city and its surroundings from a height of 185 meters. Visitors can ride the elevator to the top of the tower and enjoy breathtaking vistas of Rotterdam's skyline, the Port of Rotterdam, and the Dutch countryside beyond. The Euromast also features a restaurant and brasserie, where guests can dine while taking in the view.", "https://www.locaties.nl/media/rjddgjlb/dji_0025_lq.jpg");
        Attraction cubeHouses = new Attraction("Cube Houses", rotterdam, "The Cube Houses, or Kubuswoningen, are a unique architectural landmark in Rotterdam. Designed by architect Piet Blom, these innovative residential buildings are tilted at an angle of 45 degrees, creating a striking visual spectacle. Visitors can explore the interior of one of the Cube Houses, known as the Kijk-Kubus, to experience firsthand what it's like to live in these unconventional homes.", "https://i0.wp.com/blog.poferries.com/wp-content/uploads/2020/03/visiting-cube-houses-rotterdam.jpg?resize=640%2C443&ssl=1");
        Attraction delfshaven = new Attraction("Delfshaven", rotterdam, "Delfshaven is a historic neighborhood in Rotterdam, known for its picturesque canals, 17th-century houses, and maritime heritage. Visitors can stroll along the quayside, admire the traditional Dutch architecture, and visit landmarks such as the Pilgrim Fathers' Church and the historic Delfshaven Harbor. Delfshaven offers a charming contrast to Rotterdam's modern skyline, providing a glimpse into the city's rich history and culture.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmiMDPKdr2BOzwQqqJyGzoNa9XKa7LQ6hGQQ&s");

        // Save attraction in database

        attractionRepository.save(rotterdamMarkthal);
        attractionRepository.save(ssRotterdam);
        attractionRepository.save(euromast);
        attractionRepository.save(cubeHouses);
        attractionRepository.save(delfshaven);


        // Attractions for cities in russia
        //Moscow

        Attraction bolshoiTheatre = new Attraction("Bolshoi Theatre", moscow, "The Bolshoi Theatre is one of the most renowned opera and ballet theaters in the world. It is known for its grand architecture, opulent interiors, and world-class performances. Visitors can attend ballets, operas, and concerts at the Bolshoi Theatre, or take a guided tour to learn about its history and backstage operations.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1eSOXMwdhxnF3FDcu_mulNS6vgHMA3OfGXw&s");
        Attraction gorkyPark = new Attraction("Gorky Park", moscow, "Gorky Park is a vast recreational area in central Moscow, offering a wide range of activities for visitors of all ages. It features scenic walking paths, landscaped gardens, playgrounds, and sports facilities. Visitors can rent bikes, boats, or rollerblades, attend outdoor concerts and festivals, or simply relax and enjoy the natural beauty of this urban oasis.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Moscow_Gorky_Park_main_portal_08-2016_img1.jpg/1200px-Moscow_Gorky_Park_main_portal_08-2016_img1.jpg");
        Attraction tretyakovGallery = new Attraction("Tretyakov Gallery", moscow, "The Tretyakov Gallery is Russia's foremost museum of Russian art, housing an extensive collection of paintings, sculptures, and icons from the 11th to the 20th century. It features masterpieces by renowned artists such as Ivan Aivazovsky, Mikhail Vrubel, and Ivan Shishkin. Visitors can admire works of art spanning various styles and periods, providing insights into Russia's rich cultural heritage.", "https://upload.wikimedia.org/wikipedia/commons/d/d8/Moscow_05-2012_TretyakovGallery.jpg");


        // Save attraction in database
        attractionRepository.save(bolshoiTheatre);
        attractionRepository.save(gorkyPark);
        attractionRepository.save(tretyakovGallery);


        //Saintpetersburg


        Attraction hermitageMuseum = new Attraction("Hermitage Museum", saintPetersburg, "The Hermitage Museum is one of the largest and most prestigious art museums in the world, housed in the magnificent Winter Palace. It boasts a vast collection of artworks, including paintings, sculptures, and decorative arts from various periods and cultures. Visitors can admire masterpieces by artists such as Leonardo da Vinci, Rembrandt, and Michelangelo, and explore the opulent interiors of the palace itself.", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Hermitage_Museum_in_Saint_Petersburg.jpg/880px-Hermitage_Museum_in_Saint_Petersburg.jpg");
        Attraction peterhofPalace = new Attraction("Peterhof Palace", saintPetersburg, "Peterhof Palace, also known as the 'Russian Versailles,' is a grand imperial palace located on the Gulf of Finland. It is renowned for its stunning gardens, elaborate fountains, and opulent interiors. Visitors can tour the palace's lavish rooms, stroll through the landscaped grounds, and marvel at the engineering marvels of the cascading fountains.", "https://www.historyhit.com/app/uploads/bis-images/5156450/Peterhof-Palace-788x537.jpg?x67928");
        Attraction mariinskyTheatre = new Attraction("Mariinsky Theatre", saintPetersburg, "The Mariinsky Theatre is one of Russia's most famous opera and ballet houses, known for its world-class performances and historic significance. It has hosted premieres of works by renowned composers such as Tchaikovsky, Rachmaninoff, and Stravinsky. Visitors can attend ballets, operas, and concerts at the Mariinsky Theatre, or take a guided tour to learn about its illustrious history and backstage operations.", "https://lh6.googleusercontent.com/proxy/FLcSu4lrYkwlUQIhPiAPCB8CuUVYWPVhWZWCRJxcUgEIZnydPvNcuhApHir8SBDLJbwT86a7By4wRiabhg7OtrJf90_JwlhMkFvTGoYaTr-twZypCjLczuFDLbZgIv7-HcHubiQ4_cUfl4IqrKX3KQzX8gWVttkgIMSEy71Cafj8w-DExdo904ypyFv0mA");
        Attraction nevskyProspect = new Attraction("Nevsky Prospect", saintPetersburg, "Nevsky Prospect is the main thoroughfare of Saint Petersburg, lined with historic buildings, shops, restaurants, and cultural institutions. It is a bustling hub of activity, offering visitors a glimpse into the city's vibrant life and dynamic atmosphere. Visitors can explore Nevsky Prospect on foot or by taking a leisurely stroll along its sidewalks, stopping to admire architectural landmarks and sample local cuisine.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrPPq-BHoVyzbDRRua-fOnFMbtOYOSF9e_cw&s");
        Attraction peterAndPaulFortress = new Attraction("Peter and Paul Fortress", saintPetersburg, "The Peter and Paul Fortress is a historic citadel located on Hare Island in the Neva River. It was founded by Peter the Great in 1703 and served as the original citadel of Saint Petersburg. Visitors can explore the fortress's bastions, ramparts, and cathedral, which houses the tombs of Russian tsars and emperors. The fortress also offers panoramic views of the city skyline and the surrounding river.", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/RUS-2016-Aerial-SPB-Peter_and_Paul_Fortress_02.jpg/1200px-RUS-2016-Aerial-SPB-Peter_and_Paul_Fortress_02.jpg");

        // Save attraction in database

        attractionRepository.save(hermitageMuseum);
        attractionRepository.save(peterhofPalace);
        attractionRepository.save(mariinskyTheatre);
        attractionRepository.save(nevskyProspect);
        attractionRepository.save(peterAndPaulFortress);



        //Attractions in iceland

        Attraction blueLagoon = new Attraction("Blue Lagoon", reykjavik, "The Blue Lagoon is a geothermal spa located in a lava field in Grindavik, southwest Iceland. It is renowned for its milky-blue waters, rich in minerals like silica and sulfur, which are believed to have healing properties. Visitors can soak in the lagoon's warm waters, indulge in spa treatments, and enjoy stunning views of the surrounding volcanic landscape.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKKUAaF5j8VCtQyBfB_wWTxigmq4GhJEGsaA&s");
        Attraction goldenCircle = new Attraction("Golden Circle", reykjavik, "The Golden Circle is a popular tourist route in southwest Iceland, known for its breathtaking natural attractions. It includes three primary stops: Thingvellir National Park, where visitors can walk between the North American and Eurasian tectonic plates; the Geysir Geothermal Area, home to the erupting geyser Strokkur; and Gullfoss Waterfall, one of Iceland's most majestic cascades.", "https://guidetoiceland.imgix.net/405157/x/0/golden-circle-2?ixlib=php-3.3.0&w=883");
        Attraction perlan = new Attraction("Perlan", reykjavik, "Perlan, or 'The Pearl,' is a landmark building in Reykjavik situated on Oskjuhlid Hill. It is known for its distinctive dome-shaped structure and rotating glass dome, which offers panoramic views of the city and surrounding landscapes. Visitors can explore the building's exhibition space, dine in its revolving restaurant, or enjoy a walk in the surrounding gardens.", "https://bradsbackpack.com/wp-content/uploads/2023/02/1.jpg");


        // Save attraction in database
        attractionRepository.save(blueLagoon);
        attractionRepository.save(goldenCircle);
        attractionRepository.save(perlan);



        //Attraction for cities in switzerland
        // zurich



        Attraction lakeZurich = new Attraction("Lake Zurich", zurich, "Lake Zurich is a scenic lake situated in the heart of the city. It offers stunning views of the surrounding mountains and is a popular destination for recreational activities such as swimming, boating, and picnicking. Visitors can take a leisurely stroll along the lake promenade, rent a paddleboat, or simply relax on the shores and enjoy the serene atmosphere.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTgPTz6QQTnudzloo2SWhdHpd8912aDzODUg&s");
        Attraction swissNationalMuseum = new Attraction("Swiss National Museum", zurich, "The Swiss National Museum is the largest cultural history museum in Switzerland, showcasing the country's rich cultural heritage from prehistoric times to the present day. Housed in a historic castle-like building, the museum features a vast collection of artifacts, including ancient artifacts, medieval art, traditional costumes, and decorative arts. Visitors can explore exhibits on Swiss history, culture, and folklore, providing insights into the nation's diverse heritage.", "https://www.nationalmuseum.ch/nationalmuseum/haeuser/3343/image-thumb__3343__museum_detail_image/limmatseite-winter_ga170216-p65-023.jpg");
        Attraction zurichOldTown = new Attraction("Old Town (Altstadt)", zurich, "Zurich's Old Town, or Altstadt, is a charming historic district known for its medieval buildings, cobblestone streets, and lively atmosphere. Visitors can wander through narrow alleyways, discover quaint shops, cafes, and galleries, and admire architectural landmarks such as the Grossmünster and Fraumünster churches. The Old Town is also home to the vibrant Niederdorf district, where visitors can enjoy shopping, dining, and nightlife.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/27/a7/58.jpg");
        Attraction uetlibergMountain = new Attraction("Uetliberg Mountain", zurich, "Uetliberg Mountain is Zurich's local mountain, offering panoramic views of the city, Lake Zurich, and the Swiss Alps. Visitors can hike or take the train to the summit, where they'll find observation towers, scenic viewpoints, and hiking trails. Uetliberg is a popular destination for outdoor activities such as hiking, mountain biking, and paragliding, as well as picnicking and enjoying the natural beauty of the Swiss countryside.", "https://www.zuerich.com/sites/default/files/web_zuerich_uetliberg_1280x960_9573.jpg");
        Attraction kunsthausZurich = new Attraction("Kunsthaus Zurich", zurich, "Kunsthaus Zurich is one of Switzerland's most important art museums, housing a vast collection of European art from the Middle Ages to the present day. It features works by renowned artists such as Rembrandt, Monet, Picasso, and Munch, as well as Swiss artists like Hodler and Giacometti. The museum also hosts temporary exhibitions, lectures, and events, providing visitors with a comprehensive overview of European art history.", "https://travel.usnews.com/images/Museum_of_Art_Kunsthaus_Zurich.jpg");


        //save attraction in database

        attractionRepository.save(lakeZurich);
        attractionRepository.save(swissNationalMuseum);
        attractionRepository.save(zurichOldTown);
        attractionRepository.save(uetlibergMountain);
        attractionRepository.save(kunsthausZurich);


        //geneva

        Attraction lakeGeneva = new Attraction("Lake Geneva", geneva, "Lake Geneva is one of the largest lakes in Europe and a defining feature of the city. It offers scenic views of the surrounding Alps and Jura mountains and is a popular destination for water sports, boat cruises, and lakeside picnics. Visitors can stroll along the lake promenade, visit parks and gardens along its shores, or take a relaxing boat ride to explore nearby towns and attractions.", "https://deih43ym53wif.cloudfront.net/chillon-castle-geneva-lake-switzerland-shutterstock_361751813_fbaba5c297.jpeg");
        Attraction jetDEau = new Attraction("Jet d'Eau", geneva, "Jet d'Eau is one of Geneva's most famous landmarks, a towering fountain located on Lake Geneva's waterfront. It shoots water up to 140 meters into the air, creating an impressive spectacle visible from miles around. Visitors can admire the fountain's beauty from the shore or take a boat cruise for a closer view. Jet d'Eau is particularly stunning at night when illuminated by lights.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsZm3sPTsQpt8vr-tlmwmuof53sSu7pu3pwQ&s");
        Attraction unitedNationsHeadquarters = new Attraction("United Nations Headquarters", geneva, "The United Nations Headquarters in Geneva is one of the largest UN centers in the world and a hub for international diplomacy and cooperation. Visitors can take guided tours of the Palais des Nations, where they'll learn about the UN's work in peace and security, human rights, and humanitarian affairs. The complex also houses a museum and exhibits on global issues and challenges.", "https://www.un.org/sites/un2.un.org/files/styles/large-article-image-style-16-9/public/field/image/579261.jpg?c=b9a8e7745187a152e03c09f6d24fc3ca");
        Attraction vieilleVille = new Attraction("Vieille Ville (Old Town)", geneva, "Geneva's Vieille Ville, or Old Town, is a charming historic district known for its narrow streets, medieval buildings, and historic landmarks. Visitors can wander through cobblestone alleys, discover hidden squares, and admire architectural gems such as the Maison Tavel and St. Peter's Cathedral. The Old Town is also home to boutique shops, cafes, and restaurants, making it a delightful area to explore on foot.", "https://www.visitesguideesef.ch/wp-content/uploads/visites-guidees-geneve-vieille-ville-2-2.jpg");
        Attraction parcDesBastions = new Attraction("Parc des Bastions", geneva, "Parc des Bastions is a picturesque park located in the heart of Geneva's Old Town. It features lush greenery, tree-lined pathways, and historic monuments, including the Reformation Wall and the University of Geneva. Visitors can relax on benches, play chess on giant boards, or enjoy a leisurely stroll through the park's tranquil surroundings. Parc des Bastions is a peaceful oasis in the heart of the city.", "https://cdn.unitycms.io/images/18bAxHyUaclAOCyGHTBoiA.jpg?op=ocroped&val=1200,1200,1000,1000,0,0&sum=SvEjYNaYiYI");


        //save attraction in database

        attractionRepository.save(lakeGeneva);
        attractionRepository.save(jetDEau);
        attractionRepository.save(unitedNationsHeadquarters);
        attractionRepository.save(vieilleVille);
        attractionRepository.save(parcDesBastions);

        //basel



        Attraction baselArtMuseum = new Attraction("Basel Art Museum", basel, "The Basel Art Museum, also known as Kunstmuseum Basel, is one of the oldest and most renowned art museums in Switzerland. It houses a vast collection of artworks from the medieval period to contemporary art, including pieces by renowned artists such as Holbein, Picasso, and Monet. Visitors can explore the museum's permanent collections and rotating exhibitions, providing insights into the history and development of European art.", "https://images.adsttc.com/media/images/5734/8253/e58e/ce59/a900/0022/large_jpg/3418_3414_1_Derek_Li_Wan_Po.jpg?1463059008");
        Attraction baselZoo = new Attraction("Basel Zoo", basel, "Basel Zoo is one of the oldest and largest zoos in Switzerland, home to over 6,000 animals from around the world. It features a wide variety of species, including mammals, birds, reptiles, and amphibians, housed in naturalistic habitats. Visitors can observe animals such as elephants, giraffes, penguins, and lions, participate in feeding sessions and animal encounters, and learn about wildlife conservation efforts.", "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcSMphmY4IZU5vTG8mXZqdh5H2A--Go0hSZf8i17JxA-3OIvFtCOPw5kjXwex3oCiBkUFwhLvZukGsTW-YljFo79WRXppjCm1dDi6JrAcA");
        Attraction rheinRiverCruise = new Attraction("Rhine River Cruise", basel, "A Rhine River cruise is a popular way to explore Basel's picturesque waterfront and scenic surroundings. Visitors can embark on a leisurely boat ride along the Rhine River, passing by historic landmarks, charming villages, and lush vineyards. Guided cruises offer informative commentary on the region's history, culture, and natural beauty, making it an enjoyable and educational experience for all ages.", "https://a-us.storyblok.com/f/1005231/1680x840/e746193d76/a-viking-longship-sails-the-middle-rhine.jpg");
        Attraction baselHistoricalMuseum = new Attraction("Basel Historical Museum", basel, "The Basel Historical Museum, or Historisches Museum Basel, is dedicated to the history and culture of the Basel region. It features permanent exhibitions on topics such as archaeology, medieval history, and everyday life in Basel. Visitors can explore artifacts, documents, and multimedia displays, providing insights into the city's past and its role in Swiss history.", "https://www.hmb.ch/fileadmin/a/hmb/dateien/bilder/2500x1170/BK-Schiff.jpg");
        Attraction baselBotanicalGarden = new Attraction("Basel Botanical Garden", basel, "The Basel Botanical Garden, or Botanischer Garten Basel, is a peaceful oasis in the heart of the city, showcasing a diverse collection of plants from around the world. It features themed gardens, greenhouses, and outdoor exhibits, including alpine plants, tropical flora, and medicinal herbs. Visitors can enjoy leisurely walks, educational tours, and seasonal events, surrounded by the beauty and tranquility of nature.", "https://botgarten.unibas.ch/fileadmin/_processed_/5/8/csm_Viktoriahaus_zwischen_Baeumen_08f1a927a0.jpg?1614736516");


        //save attraction in dat

        attractionRepository.save(baselArtMuseum);
        attractionRepository.save(baselZoo);
        attractionRepository.save(rheinRiverCruise);
        attractionRepository.save(baselHistoricalMuseum);
        attractionRepository.save(baselBotanicalGarden);

        // Top Attractions for Hanoi
        Attraction hanoiOldQuarter = new Attraction("Hanoi Old Quarter", hanoi, "The Hanoi Old Quarter is the historic heart of Hanoi, characterized by its narrow streets, ancient buildings, and bustling markets. It is one of the oldest and most vibrant parts of the city, with a history dating back over a thousand years. Visitors can wander through its maze-like alleyways, discover traditional shops and street vendors, and experience the sights, sounds, and flavors of authentic Vietnamese culture.", "https://duongsrestaurant.com/wp-content/uploads/2019/07/hanoi-old-quarter-ancient-streets-of-hanoi.jpg");
        Attraction ninhBinhAttraction = new Attraction("Ninh Binh", hanoi, "Ninh Binh is a province in northern Vietnam, known for its stunning natural landscapes, rich cultural heritage, and historical sites. It is often referred to as the 'Halong Bay on land' due to its karst limestone mountains, lush rice paddies, and winding waterways. Ninh Binh is home to attractions such as Tam Coc, Trang An Landscape Complex, and Mua Caves, offering visitors opportunities for boat tours, cave exploration, and cultural immersion.", "https://www.insideasiatours.com/sites/default/files/2020-09/PLACE-PAGE-Vietnam_Ninh-Binh-Paddies-and-Mountains-iStock_resized.jpg");
        Attraction sapaAttraction = new Attraction("Sapa", hanoi, "Sapa is a town in Lao Cai Province, located in the northwest region of Vietnam. It is renowned for its stunning mountain landscapes, terraced rice fields, and vibrant ethnic minority culture. Sapa is a popular destination for trekking, hiking, and cultural tourism, with attractions such as Fansipan Peak, Cat Cat Village, and the Love Waterfall. Visitors can explore the town's markets, interact with local ethnic communities, and enjoy breathtaking views of the Hoang Lien Son mountain range.", "https://i0.wp.com/touristjourney.com/wp-content/uploads/2020/05/Sapa-scaled.jpg?fit=2560%2C1108&ssl=1");
        Attraction hoChiMinhMausoleum = new Attraction("Ho Chi Minh Mausoleum", hanoi, "The Ho Chi Minh Mausoleum is a monumental building located in Ba Dinh Square, Hanoi, dedicated to the memory of Vietnamese revolutionary leader Ho Chi Minh. It serves as the final resting place of Ho Chi Minh's embalmed body, which is preserved in a glass sarcophagus within the mausoleum. Visitors can pay their respects to Ho Chi Minh, view his embalmed remains, and learn about his life and legacy through exhibits and displays within the mausoleum.", "https://statics.vinpearl.com/ho-chi-minh-mausoleum-thumb_1662726979.jpeg");
        Attraction haLongBay = new Attraction("Ha Long Bay", hanoi, "Ha Long Bay is a UNESCO World Heritage site located in Quang Ninh Province, famous for its emerald waters and thousands of towering limestone islands topped with rainforests. Visitors can take boat tours to explore the bay's stunning seascape, kayak through its serene waters, visit floating fishing villages, and explore the numerous caves and grottoes scattered throughout the bay. Popular activities include cruising on traditional junk boats, swimming, and diving in the clear waters, as well as hiking on the islands to enjoy panoramic views of the bay.","https://media.tacdn.com/media/attractions-splice-spp-674x446/12/3f/40/63.jpg");

        attractionRepository.save(haLongBay);
        attractionRepository.save(ninhBinhAttraction);
        attractionRepository.save(sapaAttraction);
        attractionRepository.save(hoChiMinhMausoleum);
        attractionRepository.save(hanoiOldQuarter);

        // Da Nang Attractions
        Attraction baNaHills = new Attraction("Ba Na Hills", daNang, "Ba Na Hills is a hill station and resort located in the Truong Son Mountains near Da Nang, Vietnam. It is known for its scenic beauty, French colonial architecture, and attractions such as the Golden Bridge and Fantasy Park. Visitors can ride the world's longest cable car to reach Ba Na Hills, enjoy panoramic views of the surrounding landscapes, explore gardens, and pagodas, and experience thrilling rides and entertainment.", "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/86/2023/08/30021548/Kh%C3%A1nh-Phan.jpg");
        Attraction dragonBridge = new Attraction("Dragon Bridge", daNang, "Dragon Bridge is a bridge over the Han River in Da Nang, Vietnam, known for its unique design and nightly dragon-shaped fire and water shows. It is one of the city's most iconic landmarks, symbolizing prosperity and good fortune. Visitors can watch the dragon breathe fire and spout water, walk along the bridge's pedestrian walkways, and enjoy views of the river and city skyline.", "https://statics.vinpearl.com/dragon-bridge-2_1664459711.jpeg");
        Attraction myKheBeach = new Attraction("My Khe Beach", daNang, "My Khe Beach is a popular beach located in Da Nang, Vietnam. It is known for its soft white sand, clear blue waters, and gentle waves, making it an ideal destination for swimming, sunbathing, and water sports. Visitors can relax on the beach, take a dip in the ocean, or enjoy activities such as surfing, jet skiing, and parasailing.", "https://statics.vinpearl.com/my-khe-beach-2_1692016028.jpg");

// Save attractions in Da Nang
        attractionRepository.save(baNaHills);
        attractionRepository.save(dragonBridge);
        attractionRepository.save(myKheBeach);

        // Hoi An Attractions
        Attraction hoiAnAncientTown = new Attraction("Hoi An Ancient Town", hoiAn, "Hoi An Ancient Town is a UNESCO World Heritage Site located in Quang Nam Province, central Vietnam. It is known for its well-preserved historic architecture, charming streets, and cultural heritage. Visitors can explore its ancient buildings, and assembly halls, stroll along the picturesque Thu Bon River, and shop for handicrafts, lanterns, and tailor-made clothing.", "https://vietnam.travel/sites/default/files/inline-images/11125-Qu%E1%BA%A3ng%20Nam-huybank%40gmail.com-hoi%20an%20ve%20dem%20.jpg");
        Attraction japaneseCoveredBridge = new Attraction("Japanese Covered Bridge", hoiAn, "Japanese Covered Bridge is a historic bridge located in Hoi An Ancient Town, Vietnam. It is one of the town's most iconic landmarks, known for its elegant design, wooden structure, and ornate decorations. Visitors can walk across the bridge, admire its architecture and carvings, and enjoy views of the surrounding canals and traditional houses.", "https://vietnam.travel/sites/default/files/inline-images/shutterstock_1506184586_resize.jpg");
        Attraction hoiAnNightMarket = new Attraction("Hoi An Night Market", hoiAn, "Hoi An Night Market is a bustling market located in the center of Hoi An Ancient Town, Vietnam. It is known for its vibrant atmosphere, colorful lanterns, and wide variety of goods for sale. Visitors can shop for souvenirs, handicrafts, clothing, and accessories, sample local street food and snacks, and enjoy live music and performances.", "https://statics.vinpearl.com/hoi-an-night-market-1_1701571361.jpg");
        Attraction traQueHerbVillage = new Attraction("Tra Que Herb Village", hoiAn, "Tra Que Herb Village is a traditional farming village located near Hoi An, Vietnam. It is known for its organic herb gardens, lush green fields, and peaceful rural scenery. Visitors can take guided tours of the village, learn about organic farming practices, participate in gardening activities, and enjoy cooking classes using fresh herbs and vegetables.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/ab/4b/37/photo1jpg.jpg?w=1200&h=1200&s=1");
        Attraction camThanhCoconutVillage = new Attraction("Cam Thanh Coconut Village", hoiAn, "Cam Thanh Coconut Village is a scenic village located near Hoi An, Vietnam. It is known for its lush coconut groves, tranquil waterways, and traditional way of life. Visitors can take boat tours of the village's water coconut forest, learn about traditional fishing and farming techniques, and enjoy activities such as basket boat rowing and crab fishing.", "https://hoianprivatetaxi.com/wp-content/uploads/2021/08/Cam-Thanh-Coconut-Village-Hoi-An-Private-Taxi.jpg");

// Save attractions in Hoi An
        attractionRepository.save(hoiAnAncientTown);
        attractionRepository.save(japaneseCoveredBridge);
        attractionRepository.save(hoiAnNightMarket);
        attractionRepository.save(traQueHerbVillage);
        attractionRepository.save(camThanhCoconutVillage);

        // Nha Trang Attractions
        Attraction vinpearlLand = new Attraction("Vinpearl Land", nhaTrang, "Vinpearl Land is a theme park located on Hon Tre Island, just off the coast of Nha Trang, Vietnam. It is known for its thrilling rides, water park, aquarium, and entertainment attractions. Visitors can take a cable car ride to the island, enjoy panoramic views of the bay, and spend the day exploring the park's attractions, including roller coasters, water slides, and dolphin shows.", "https://www.vietnamonline.com/media/uploads/froala_editor/images/vno_VPNT1.jpg");
        Attraction nhaTrangBeach = new Attraction("Nha Trang Beach", nhaTrang, "Nha Trang Beach is a beautiful sandy beach located along the coastline of Nha Trang, Vietnam. It is known for its crystal-clear waters, gentle waves, and golden sands, making it a popular destination for swimming, sunbathing, and water sports. Visitors can relax on the beach, rent sun loungers and umbrellas, and enjoy activities such as snorkeling, diving, and jet skiing.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/58/26/62/photo0jpg.jpg?w=1200&h=-1&s=1");
        Attraction honChongPromontory = new Attraction("Hon Chong Promontory", nhaTrang, "Hon Chong Promontory is a scenic coastal area located in Nha Trang, Vietnam. It is known for its unique rock formations, tide pools, and panoramic views of the South China Sea. Visitors can climb the rocky promontory, explore the natural sculptures and caves, and enjoy breathtaking sunsets over the ocean.", "https://statics.vinpearl.com/hon-chong-promontory-1_1699201109.jpg");


// Save attractions in Nha Trang
        attractionRepository.save(vinpearlLand);
        attractionRepository.save(nhaTrangBeach);
        attractionRepository.save(honChongPromontory);

        // Jakarta Attractions
        Attraction nationalMonument = new Attraction("National Monument (Monas)", jakarta, "The National Monument (Monas) is an iconic landmark and national monument located in the heart of Jakarta, Indonesia. It symbolizes the country's struggle for independence and is one of the most visited attractions in the city. Visitors can take an elevator to the top of the monument for panoramic views of Jakarta, explore the museum at the base of the monument, and enjoy the surrounding Merdeka Square.", "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcS0bzTYxbEBX-HjxcnV2QP9OyDyzRzT6M6hZKhFaH7i6lW6vaDo6xTG-hs0FCoLikobrK7hOVAkl626CE3WKAWF51v0fJZtzSk2TDcRUA");
        Attraction JakartaOldTown = new Attraction("Jakarta Old Town (Kota Tua)", jakarta, "Jakarta Old Town, also known as Kota Tua, is a historic district located in the northern part of Jakarta, Indonesia. It features well-preserved colonial-era buildings, museums, and landmarks dating back to the Dutch colonial period. Visitors can explore the cobblestone streets, visit museums such as the Jakarta History Museum and Wayang Museum, and take a leisurely bike ride around the area.", "https://live.staticflickr.com/5118/29275545133_4b3f0afa7f_b.jpg");
        Attraction tamanMiniIndonesia = new Attraction("Taman Mini Indonesia Indah", jakarta, "Taman Mini Indonesia Indah (Beautiful Indonesia in Miniature Park) is a cultural theme park located in Jakarta, Indonesia. It showcases the rich diversity of Indonesia's culture, traditions, and architecture through miniature replicas of traditional houses, landmarks, and cultural exhibits from across the country's provinces. Visitors can explore the park by walking or renting bicycles, visit museums, theaters, and pavilions, and learn about Indonesia's history and heritage.", "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTCFJRDTuGX_7B-3tVAYfllLAzWctKi_8iRBmTks2aOxiZu1IS6sfLgZTDwdasKvjyK6v4x-HX1RF6uRVaz6FFu3pUgW46zH-59jUfgf-k");
        Attraction ragunanZoo = new Attraction("Ragunan Zoo", jakarta, "Ragunan Zoo is a zoological park located in South Jakarta, Indonesia. It is one of the oldest and largest zoos in Southeast Asia, home to a wide variety of animal species from Indonesia and around the world. Visitors can explore the zoo's spacious grounds, see animals such as elephants, orangutans, and Komodo dragons, and enjoy family-friendly activities such as animal shows and feeding sessions.", "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQN3Sgj-P7VlWYPXc1pWXAGjPWi3NNXWzX3jn4Nu4MgrhSpAkKjaRDbehPW6BLX4I4w4IUJmgBOgJDuynUjC-IPH_uSu69LXWnDjh1TZg");
        Attraction ancolDreamland = new Attraction("Ancol Dreamland", jakarta, "Ancol Dreamland is a waterfront entertainment complex located along the Jakarta Bay coastline in North Jakarta, Indonesia. It features a variety of attractions and activities for visitors of all ages, including amusement parks, water parks, beaches, and cultural attractions. Visitors can enjoy rides and attractions at Fantasy World and Atlantis Water Adventure, relax on the beach, dine at restaurants, and watch cultural performances at Pasar Seni (Art Market).", "https://lh5.googleusercontent.com/p/AF1QipMWlgq8gjA9B9DGhnbnCUiuK_gQFdHqg7loRcRn=w1080-h624-n-k-no");

// Save attractions in Jakarta
        attractionRepository.save(nationalMonument);
        attractionRepository.save(JakartaOldTown);
        attractionRepository.save(tamanMiniIndonesia);
        attractionRepository.save(ragunanZoo);
        attractionRepository.save(ancolDreamland);
// Bandung Attractions
        Attraction tangkubanPerahu = new Attraction("Tangkuban Perahu", bandung, "Tangkuban Perahu is an active stratovolcano located near Bandung, West Java, Indonesia. It is one of the most popular tourist attractions in the region, known for its distinctive shape and scenic beauty. Visitors can hike to the crater rim, explore fumaroles and hot springs, and enjoy panoramic views of the surrounding mountains and lush forests.", "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcTSjQuxTMIA3EnPxIYLqpzbXEsNy1f3W3nuAE9Fr2NcpXO_Q-21pZ3-hrkXTXU9o86Y8GLoi3A9WkL5r-Z_EqbFts_j9Audp1Ofej1S4w");
        Attraction ciaterHotSpring = new Attraction("Ciater Hot Spring", bandung, "Ciater Hot Spring is a natural hot spring resort located near Bandung, West Java, Indonesia. It is known for its therapeutic mineral waters and scenic surroundings, making it a popular destination for relaxation and wellness. Visitors can soak in hot spring pools, swim in cool streams, and enjoy beautiful views of the surrounding tea plantations and mountains.", "https://www.subang.indonesia-tourism.com/images/ciater_hot_spring.jpg");
        Attraction transStudioBandung = new Attraction("Trans Studio Bandung", bandung, "Trans Studio Bandung is a large indoor theme park located in Bandung, West Java, Indonesia. It offers a wide range of rides, attractions, and entertainment experiences for visitors of all ages, including roller coasters, thrill rides, live shows, and interactive exhibits. Visitors can enjoy adrenaline-pumping rides, watch spectacular performances, and explore themed zones such as Hollywood, Lost City, and Magic Corner.", "https://lh5.googleusercontent.com/p/AF1QipOyYOFK4I4TsAM7_ZrnMIcHgW51puYIkUK85dLY=w1080-h624-n-k-no");
        Attraction floatingMarket = new Attraction("Floating Market Lembang", bandung, "Floating Market Lembang is a unique culinary and cultural attraction located in Lembang, near Bandung, West Java, Indonesia. It features traditional wooden boats selling a variety of local snacks, dishes, and handicrafts along a man-made canal. Visitors can explore the market by boat, sample delicious Indonesian street food, and watch cultural performances such as traditional music and dance.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/30/64/03/floating-market-lembang.jpg?w=1200&h=-1&s=1");
        Attraction farmhouseSusana = new Attraction("Farmhouse Susana", bandung, "Farmhouse Susana is a European-style theme park and tourist village located in Lembang, near Bandung, West Java, Indonesia. It features picturesque Dutch-style buildings, gardens, and attractions inspired by European countryside living. Visitors can take photos in front of windmills and wooden houses, visit a replica Dutch castle, and enjoy activities such as horse riding, feeding animals, and shopping for souvenirs.", "https://media-cdn.tripadvisor.com/media/photo-s/0d/7c/59/70/farmhouse-lembang.jpg");

// Save attractions in Bandung
        attractionRepository.save(tangkubanPerahu);
        attractionRepository.save(ciaterHotSpring);
        attractionRepository.save(transStudioBandung);
        attractionRepository.save(floatingMarket);
        attractionRepository.save(farmhouseSusana);
// Surabaya Attractions
        Attraction suramaduBridge = new Attraction("Suramadu Bridge", surabaya, "Suramadu Bridge is a cable-stayed bridge that connects the islands of Java and Madura in Indonesia. It is one of the longest bridges in Southeast Asia and a significant landmark in Surabaya, East Java. Visitors can drive or walk across the bridge, enjoy panoramic views of the Madura Strait, and visit attractions such as the Surabaya North Quay and Kenjeran Beach.", "https://www.colorkinetics.com/content/dam/color-kinetics/showcases/suramadu-bridge/suramadu-bridge4_lg.jpg");
        Attraction tunjunganPlaza = new Attraction("Tunjungan Plaza", surabaya, "Tunjungan Plaza is a shopping mall located in the heart of Surabaya, East Java, Indonesia. It is one of the largest and most popular shopping destinations in the city, known for its wide range of stores, restaurants, and entertainment facilities. Visitors can shop for clothing, electronics, and souvenirs, dine at international restaurants, and watch movies at the cinema.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/c1/61/5f/tunjungan-plaza.jpg?w=1200&h=1200&s=1");
        Attraction surabayaZoo = new Attraction("Surabaya Zoo", surabaya, "Surabaya Zoo, also known as Kebun Binatang Surabaya, is a zoological park located in Surabaya, East Java, Indonesia. It is one of the oldest and largest zoos in Southeast Asia, home to a diverse collection of animal species from Indonesia and around the world. Visitors can explore the zoo's spacious grounds, see animals such as elephants, tigers, and orangutans, and enjoy family-friendly activities such as animal shows and feeding sessions.", "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcQN4qq2V-bsEEYtGn3tqXZ4IETHMzvdGihewrI3x1-2a9EgPZ7oC-D_bqodgdzte5vGIzoRBup3r7uypKRlMj2m_31vTx6vo4GhnUsE4D0");
        Attraction houseOfSampoerna = new Attraction("House of Sampoerna", surabaya, "House of Sampoerna is a historic museum and cigarette factory located in Surabaya, East Java, Indonesia. It offers visitors a glimpse into the history and heritage of Indonesia's tobacco industry, as well as the culture and traditions of Surabaya. Visitors can take guided tours of the museum, learn about the art of cigarette making, and explore exhibits on Indonesian art, culture, and history.", "https://res.cloudinary.com/tourhq/image/upload/f_auto,g_auto,c_fill,q_auto:best,fl_progressive,h_507,w_900/ruqimskprmbnpki5okae");
        Attraction surabayaSubmarineMonument = new Attraction("Surabaya Submarine Monument", surabaya, "Surabaya Submarine Monument is a decommissioned submarine turned museum located in Surabaya, East Java, Indonesia. It is dedicated to the Indonesian Navy and serves as a memorial to the heroes of the KRI Pasopati 410 submarine. Visitors can explore the interior of the submarine, learn about its history and operations, and see exhibits on naval warfare and maritime heritage.", "https://image.arrivalguides.com/x/03/c1f5e184796009fcc0b96f5ffc827f7a.jpg");

// Save attractions in Surabaya
        attractionRepository.save(suramaduBridge);
        attractionRepository.save(tunjunganPlaza);
        attractionRepository.save(surabayaZoo);
        attractionRepository.save(houseOfSampoerna);
        attractionRepository.save(surabayaSubmarineMonument);
// Yogyakarta Attractions
        Attraction kratonYogyakarta = new Attraction("Kraton Yogyakarta", yogyakarta, "Kraton Yogyakarta, also known as the Yogyakarta Palace, is the official residence of the Sultan of Yogyakarta and the royal court of the Yogyakarta Sultanate. It is a cultural and historical landmark located in the heart of Yogyakarta city. Visitors can explore the palace complex, learn about Javanese royal traditions and ceremonies, and visit the Sultan's living quarters, museums, and cultural exhibits.", "https://authentic-indonesia.com/wp-content/uploads/2018/04/the-kraton-of-yogyakarta.jpg");
        Attraction tamanSariWaterCastle = new Attraction("Taman Sari Water Castle", yogyakarta, "Taman Sari Water Castle, also known as Taman Sari Palace or Taman Sari Underground Mosque, is a historical water palace located in Yogyakarta, Indonesia. It was built in the 18th century as a royal garden and pleasure palace for the Sultan of Yogyakarta. Visitors can explore the palace's complex system of pools, bathing areas, and underground tunnels, and learn about its history and architectural significance.", "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQxOABpregVPdvG3cev67vFzX6h3UFeq-6UGOoGU4NUgFV6vFsNm8ADEut7CTBRO9Ub9wWkQNt-oBkBj-as-k3qG5qjUqOYNuOsqbAocw");
        Attraction malioboroStreet = new Attraction("Malioboro Street", yogyakarta, "Malioboro Street is a bustling shopping street and cultural hub located in the heart of Yogyakarta, Indonesia. It is known for its vibrant atmosphere, street vendors, and wide range of shops selling clothing, handicrafts, batik textiles, and souvenirs. Visitors can stroll along the street, shop for traditional Javanese goods, sample local street food, and experience Javanese culture and hospitality.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4OzrTg0B7CqG8JlaIbvkQfCSgV1haxeQ2lw&s");

// Save attractions in Yogyakarta
        attractionRepository.save(kratonYogyakarta);
        attractionRepository.save(tamanSariWaterCastle);
        attractionRepository.save(malioboroStreet);
// Top 5 attractions in Tokyo
        Attraction tokyoTower = new Attraction("Tokyo Tower", tokyo, "Tokyo Tower is a landmark communications and observation tower located in the Shiba-koen district of Minato, Tokyo, Japan. It is one of the most iconic symbols of Tokyo, offering panoramic views of the city skyline from its observation decks. Visitors can also enjoy shopping, dining, and various attractions at the base of the tower.", "https://byfood.b-cdn.net/api/public/assets/9392/content");
        Attraction uenoPark = new Attraction("Ueno Park", tokyo, "Ueno Park is a spacious public park located in Ueno, Taito, Tokyo, Japan. It is a popular destination for both locals and tourists, offering a wide range of attractions including museums, and gardens. Visitors can explore attractions such as Ueno Zoo, Tokyo National Museum, Shinobazu Pond, and enjoy cherry blossom viewing during spring.", "https://www.datocms-assets.com/101439/1692427273-ueno-park.jpg?auto=format&fit=max&w=1200");
        Attraction marioStreetKart = new Attraction("Mario Street Kart", tokyo, "Mario Street Kart is a unique and fun attraction in Tokyo where participants can dress up as characters from the Mario Kart video game series and drive go-karts through the streets of the city. This popular activity offers a thrilling way to see Tokyo from a new perspective.", "https://media.timeout.com/images/106004503/750/422/image.jpg");
        Attraction shibuyaCrossing = new Attraction("Shibuya Crossing", tokyo, "Shibuya Crossing is a famous scramble crossing in the Shibuya ward of Tokyo, Japan. It is known for its immense pedestrian traffic and is often featured in movies and media as a symbol of Tokyo's bustling urban environment. The crossing is located in front of Shibuya Station.", "https://media.cnn.com/api/v1/images/stellar/prod/190614113003-19-shibuya-crossing-story-only.jpg?q=w_1110,c_fill");
// Save attractions in Tokyo
        attractionRepository.save(tokyoTower);
        attractionRepository.save(uenoPark);
        attractionRepository.save(shibuyaCrossing);
        attractionRepository.save(marioStreetKart);
// Top 5 attractions in Yokohama
        Attraction yokohamaChinatown = new Attraction("Yokohama Chinatown", yokohama, "Yokohama Chinatown is the largest Chinatown in Japan, located in the Yokohama city center. It is known for its vibrant atmosphere, colorful decorations, and wide variety of Chinese cuisine. Visitors can explore the bustling streets, sample delicious Chinese dishes and street food, and shop for souvenirs and traditional goods.", "https://byfood.b-cdn.net/api/public/assets/9283/content?optimizer=image");
        Attraction minatoMirai = new Attraction("Minato Mirai 21", yokohama, "Minato Mirai 21 is a futuristic waterfront district in Yokohama, Japan. It features iconic landmarks such as Landmark Tower, Yokohama Cosmo World, and Yokohama Red Brick Warehouse. Visitors can enjoy shopping, dining, entertainment, and panoramic views of Yokohama Bay from observation decks and waterfront promenades.", "https://www.japan-guide.com/g20/3200_02.jpg");
        Attraction sankeienGarden = new Attraction("Sankeien Garden", yokohama, "Sankeien Garden is a traditional Japanese garden located in the Naka Ward of Yokohama, Japan. It is known for its beautiful landscapes, historic buildings, and seasonal flower displays. Visitors can explore the garden's walking paths, ponds, tea houses, and historic buildings relocated from Kyoto, Kamakura, and other parts of Japan.", "https://www.yokohamajapan.com/img_data/things_sub2_109.JPG?2270424");
        Attraction yokohamaLandmarkTower = new Attraction("Yokohama Landmark Tower", yokohama, "Yokohama Landmark Tower is a skyscraper located in the Minato Mirai 21 district of Yokohama, Japan. It is one of the tallest buildings in Japan, offering panoramic views of Yokohama and Tokyo from its observation deck on the 69th floor. Visitors can also enjoy shopping, dining, and entertainment facilities at the adjacent Landmark Plaza.", "https://onb-cdn.b-cdn.net/images-stn-yokohama/55-Yokohama-Landmark-Tower1.jpg");
        Attraction redBrickWarehouse = new Attraction("Yokohama Red Brick Warehouse", yokohama, "Yokohama Red Brick Warehouse is a historic warehouse complex located in the Minato Mirai 21 district of Yokohama, Japan. It has been renovated into a shopping, dining, and event space, featuring boutiques, restaurants, cafes, and galleries. Visitors can explore the waterfront area, attend cultural events, and enjoy views of Yokohama Bay.", "https://res-3.cloudinary.com/jnto/image/upload/w_2064,h_1300,c_fill,f_auto,fl_lossy,q_auto/v1648547516/kanagawa/M_00504_001");

// Save attractions in Yokohama
        attractionRepository.save(yokohamaChinatown);
        attractionRepository.save(minatoMirai);
        attractionRepository.save(sankeienGarden);
        attractionRepository.save(yokohamaLandmarkTower);
        attractionRepository.save(redBrickWarehouse);
// Top 5 attractions in Osaka
        Attraction osakaCastle = new Attraction("Osaka Castle", osaka, "Osaka Castle is a historic landmark and one of Japan's most famous castles, located in Chuo-ku, Osaka, Japan. It is known for its impressive architecture, beautiful gardens, and historical significance. Visitors can explore the castle's interior museum, climb to the top for panoramic views of Osaka, and enjoy cherry blossom viewing during spring.", "https://www.wendywutours.com.au/resource/upload/900/banner-osaka-castle.jpg");
        Attraction dotonbori = new Attraction("Dotonbori", osaka, "Dotonbori is a lively entertainment district located in the Namba area of Osaka, Japan. It is known for its vibrant nightlife, colorful neon lights, and iconic landmarks such as the Glico Running Man and Kani Doraku Crab. Visitors can explore the bustling streets, dine at local restaurants serving Osaka's famous street food, and experience the vibrant atmosphere of the city.", "https://nb-cdn.b-cdn.net/images-stn-osaka/118-Dotonbori-Area-Osaka1.jpg");
        Attraction universalStudiosJapan = new Attraction("Universal Studios Japan", osaka, "Universal Studios Japan is a theme park located in Osaka, Japan. It offers a wide range of attractions, entertainment, and themed areas based on popular Hollywood movies and TV shows. Visitors can enjoy thrilling rides, shows, and attractions such as The Wizarding World of Harry Potter, Jurassic Park, and Minion Park.", "https://www.travelcaffeine.com/wp-content/uploads/2022/09/night-super-nintendo-world-mario-land-universal-studios-bricker-1245.jpg");
        Attraction osakaAquariumKaiyukan = new Attraction("Osaka Aquarium Kaiyukan", osaka, "Osaka Aquarium Kaiyukan is one of the largest aquariums in the world, located in Osaka, Japan. It features a diverse range of marine life from around the globe, housed in several themed exhibits and habitats. Visitors can explore the aquarium's various zones, including the Pacific Ocean, Antarctic, and Great Barrier Reef, and learn about marine conservation and biodiversity.", "https://ik.imagekit.io/tvlk/xpe-asset/AyJ40ZAo1DOyPyKLZ9c3RGQHTP2oT4ZXW+QmPVVkFQiXFSv42UaHGzSmaSzQ8DO5QIbWPZuF+VkYVRk6gh-Vg4ECbfuQRQ4pHjWJ5Rmbtkk=/2000154205996/Osaka-Aquarium-KAIYUKAN-035b924e-908c-4ca7-81f6-471593219688.jpeg?_src=imagekit&tr=c-at_max,h-260,q-100,w-412");

// Save attractions in Osaka
        attractionRepository.save(osakaCastle);
        attractionRepository.save(dotonbori);
        attractionRepository.save(universalStudiosJapan);
        attractionRepository.save(osakaAquariumKaiyukan);
// Top 5 attractions in Nagoya
        Attraction nagoyaCastle = new Attraction("Nagoya Castle", nagoya, "Nagoya Castle is a historic castle located in Nagoya, Japan. It is one of the city's most iconic landmarks, known for its majestic architecture, beautiful gardens, and cultural significance. Visitors can explore the castle's interior museum, climb to the top of the main tower for panoramic views of Nagoya, and enjoy cherry blossom viewing during spring.", "https://upload.wikimedia.org/wikipedia/commons/5/56/Nagoya_Castle_7.jpg");
        Attraction portOfNagoyaPublicAquarium = new Attraction("Port of Nagoya Public Aquarium", nagoya, "Port of Nagoya Public Aquarium is a marine aquarium located in Nagoya, Japan. It is one of the largest and most impressive aquariums in Japan, featuring a wide variety of marine life from around the world. Visitors can explore themed exhibits such as the Antarctic Ocean and Amazon Rainforest, watch dolphin and sea lion shows, and learn about marine conservation.", "https://www.nagoya-info.jp/upload/spots/large/6028190875e2fdbbc8f633.jpg");
        Attraction nagoyaCityScienceMuseum = new Attraction("Nagoya City Science Museum", nagoya, "Nagoya City Science Museum is a science museum located in Nagoya, Japan. It features interactive exhibits, hands-on experiments, and educational programs covering various fields of science and technology. Visitors can learn about astronomy, biology, physics, and robotics through interactive displays and demonstrations.", "https://content.fun-japan.jp/renewal-prod/cms/articles/content/fd948cca15dda99f862e67289c08626396c54dae.jpg");

// Save attractions in Nagoya
        attractionRepository.save(nagoyaCastle);
        attractionRepository.save(portOfNagoyaPublicAquarium);
        attractionRepository.save(nagoyaCityScienceMuseum);
// Top 5 attractions in Sapporo
        Attraction odoriPark = new Attraction("Odori Park", sapporo, "Odori Park is a large public park located in the heart of Sapporo, Japan. It stretches for several blocks along Odori Boulevard and is a popular destination for locals and tourists alike. Visitors can enjoy seasonal events and festivals, stroll along tree-lined pathways, and relax in open green spaces.", "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/459000/459418-Odori-Park.jpg");
        Attraction moerenumaPark = new Attraction("Moerenuma Park", sapporo, "Moerenuma Park is a unique public park located in Sapporo, Japan. It was designed by renowned artist and architect Isamu Noguchi and features distinctive sculptures, playgrounds, and landscaped gardens. Visitors can enjoy walking and cycling paths, outdoor art installations, and panoramic views of the surrounding landscape.", "https://www.sapporo.travel/cms/wp-content/uploads/2020/10/f_moere_01main-1200x600-1.jpg");

// Save attractions in Sapporo
        attractionRepository.save(odoriPark);
        attractionRepository.save(moerenumaPark);
// Top 5 attractions in Beijing
        Attraction greatWallOfChina = new Attraction("Great Wall of China", beijing, "The Great Wall of China is one of the most iconic landmarks in the world, located near Beijing, China. It is a UNESCO World Heritage Site and one of the Seven Wonders of the World, known for its historical significance, architectural grandeur, and stunning scenery. Visitors can explore various sections of the Great Wall, hike along its ancient ramparts, and marvel at panoramic views of the surrounding landscape.", "https://images.nationalgeographic.org/image/upload/t_edhub_resource_key_image/v1638892506/EducationHub/photos/the-great-wall-of-china.jpg");
        Attraction summerPalace = new Attraction("Summer Palace", beijing, "The Summer Palace is a vast imperial garden complex located in Beijing, China. It is a UNESCO World Heritage Site and one of the most famous classical gardens in the world, known for its natural beauty, architectural splendor, and historical significance. Visitors can explore the palace's pavilions, halls, and gardens, take boat rides on Kunming Lake, and enjoy scenic views of Longevity Hill and the surrounding landscape.", "https://www.roselinde.me/wp-content/uploads/2019/02/summerpalacebeijing4.jpg");
        Attraction hutongAlleyways = new Attraction("Hutong Alleyways", beijing, "Hutong Alleyways are narrow alleys or lanes formed by traditional courtyard residences in Beijing, China. They are a unique and charming feature of Beijing's urban landscape, offering glimpses into the city's rich history, culture, and daily life. Visitors can explore the hutong alleyways on foot, cycle through them on a rickshaw, and discover hidden gems such as local shops, tea houses, and traditional courtyard homes.", "https://cxgveiouca.cloudimg.io/familyhotelfinder.com/wp-content/uploads/Beijings-Hutongs1-SH.jpg?w=960&h=540&func=cover");

// Save attractions in Beijing
        attractionRepository.save(greatWallOfChina);
        attractionRepository.save(summerPalace);
        attractionRepository.save(hutongAlleyways);
// Top 5 attractions in Shanghai
        Attraction theBund = new Attraction("The Bund", shanghai, "The Bund is a waterfront promenade and historic district located along the Huangpu River in Shanghai, China. It is known for its iconic skyline, featuring colonial-era buildings on one side and modern skyscrapers on the other. Visitors can enjoy panoramic views of Shanghai's skyline, take leisurely strolls along the promenade, and admire architectural landmarks such as the Oriental Pearl Tower and Shanghai Tower.", "https://www.asiaodysseytravel.com/images/china-tours/group-tours/the-bund-700-9.jpg");
        Attraction yuGarden = new Attraction("Yu Garden", shanghai, "Yu Garden, also known as Yuyuan Garden, is a classical Chinese garden located in the Old City of Shanghai, China. It is a UNESCO World Heritage Site and one of the city's most famous landmarks, known for its beautiful architecture, tranquil ponds, and lush greenery. Visitors can explore the garden's pavilions, rockeries, and traditional tea houses, and admire ornate sculptures and carvings.", "https://www.china-roads.com/wp-content/uploads/2016/06/Yu-Yuan-Gardens-1.jpg");
        Attraction shanghaiDisneyland = new Attraction("Shanghai Disneyland", shanghai, "Shanghai Disneyland is a world-class theme park located in Pudong, Shanghai, China. It is the first Disney park in mainland China and offers a wide range of attractions, entertainment, and themed areas based on popular Disney movies and characters. Visitors can enjoy thrilling rides, live shows, parades, and meet-and-greet opportunities with beloved Disney characters.", "https://static01.nyt.com/images/2017/07/09/travel/09SHANGHAI1/09SHANGHAI1-superJumbo.jpg");
        Attraction orientalPearlTower = new Attraction("Oriental Pearl Tower", shanghai, "The Oriental Pearl Tower is an iconic landmark and observation tower located in Pudong, Shanghai, China. It is one of the tallest buildings in Asia and a symbol of Shanghai's modernization and economic development. Visitors can ride high-speed elevators to the observation decks, enjoy panoramic views of Shanghai's skyline, and visit the Shanghai History Museum and Space Museum located within the tower.", "https://news.cgtn.com/news/2020-11-10/Symbols-of-Shanghai-Pearl-of-the-Orient-ViKoiSMU36/img/9171ba06ef1142d59cd47b6bbc3217b1/9171ba06ef1142d59cd47b6bbc3217b1.jpeg");
        Attraction shanghaiMuseum = new Attraction("Shanghai Museum", shanghai, "Shanghai Museum is a renowned museum located in the People's Square of Shanghai, China. It is one of China's largest and most prestigious museums, known for its extensive collection of ancient Chinese art, artifacts, and cultural relics. Visitors can explore galleries dedicated to Chinese bronzes, ceramics, calligraphy, painting, jade, and furniture, and learn about China's rich cultural heritage and history.", "https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1200,h_630/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/jcf0wjttbjvoej9gcojv/ShangHai%20museum.jpg");

// Save attractions in Shanghai
        attractionRepository.save(theBund);
        attractionRepository.save(yuGarden);
        attractionRepository.save(shanghaiDisneyland);
        attractionRepository.save(orientalPearlTower);
        attractionRepository.save(shanghaiMuseum);
// Top 5 attractions in Guangzhou
        Attraction cantonTower = new Attraction("Canton Tower", guangzhou, "Canton Tower, also known as Guangzhou Tower, is a landmark observation tower located in Haizhu District, Guangzhou, China. It is one of the tallest buildings in the world and offers panoramic views of Guangzhou and the Pearl River Delta from its observation decks. Visitors can enjoy attractions such as the Bubble Tram, Sky Drop, and outdoor skywalk.", "https://www.chinadiscovery.com/assets/images/travel-guide/guangzhou/canton-tower/canton-tower-768-1.jpg");
        Attraction shamianIsland = new Attraction("Shamian Island", guangzhou, "Shamian Island is a historic and scenic island located in Liwan District, Guangzhou, China. It is known for its charming colonial architecture, tree-lined streets, and tranquil atmosphere. Visitors can stroll along the waterfront promenade, admire historic buildings such as the British and French Consulates, and relax in picturesque parks and gardens.", "https://image-tc.galaxy.tf/wijpeg-4j9q67inpjwggl91bxywyn19m/3_standard.jpg?crop=112%2C0%2C1777%2C1333");
        Attraction chimelongParadise = new Attraction("Chimelong Paradise", guangzhou, "Chimelong Paradise is a large-scale amusement park located in Panyu District, Guangzhou, China. It features a wide range of thrilling rides, shows, and attractions for visitors of all ages. Highlights include roller coasters, water rides, animal exhibits, and live performances. Visitors can also explore adjacent attractions such as Chimelong Safari Park and Chimelong Water Park.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/0a/03/a3/chimelong-water-park.jpg?w=1200&h=-1&s=1");

// Save attractions in Guangzhou
        attractionRepository.save(cantonTower);
        attractionRepository.save(shamianIsland);
        attractionRepository.save(chimelongParadise);
// Top 5 attractions in Chengdu
        Attraction giantPandaBreedingResearchBase = new Attraction("Giant Panda Breeding Research Base", chengdu, "Giant Panda Breeding Research Base is a conservation center and tourist attraction located in Chengdu, China. It is dedicated to the preservation and breeding of giant pandas, one of the world's most endangered species. Visitors can observe pandas in their natural habitat, learn about conservation efforts, and participate in educational programs and activities.", "https://img2.chinadaily.com.cn/images/201908/01/5d42430da310d8304553c21f.jpeg");
        Attraction jinliAncientStreet = new Attraction("Jinli Ancient Street", chengdu, "Jinli Ancient Street is a historic pedestrian street located in the heart of Chengdu, China. It is known for its traditional architecture, lively atmosphere, and diverse array of shops, restaurants, and cultural attractions. Visitors can explore the street's ancient buildings, sample local snacks and delicacies, and shop for souvenirs and handicrafts.", "https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_500,h_280/w_30,x_5,y_5,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/jcesskqb0ykzw77apt2n/JinliAncientStreet.jpg");
        Attraction dujiangyanIrrigationSystem = new Attraction("Dujiangyan Irrigation System", chengdu, "Dujiangyan Irrigation System is an ancient water management system located in Dujiangyan, near Chengdu, China. It is a UNESCO World Heritage Site and one of the oldest and most successful irrigation projects in the world. Visitors can explore the system's dams, canals, and aqueducts, learn about its history and engineering innovations, and enjoy scenic views of the surrounding landscape.", "https://images.chinahighlights.com/allpicture/2019/01/6738521f9115497992efe9f6_cut_800x500_61.jpg");

// Save attractions in Chengdu
        attractionRepository.save(giantPandaBreedingResearchBase);
        attractionRepository.save(jinliAncientStreet);
        attractionRepository.save(dujiangyanIrrigationSystem);
// Top 5 attractions in Shenzhen
        Attraction windowOfTheWorld = new Attraction("Window of the World", shenzhen, "Window of the World is a theme park located in the Nanshan District of Shenzhen, China. It features miniature replicas of famous landmarks and scenic spots from around the world, including the Eiffel Tower, Taj Mahal, and Egyptian pyramids. Visitors can explore the park's themed zones, enjoy cultural performances, and take photos with iconic landmarks.", "https://www.sz.gov.cn/img/0/317/317249/1352125.jpg");
        Attraction shenzhenBayPark = new Attraction("Shenzhen Bay Park", shenzhen, "Shenzhen Bay Park is a waterfront park located along the coastline of Shenzhen, China. It offers stunning views of Shenzhen Bay and the Hong Kong skyline, as well as recreational facilities such as jogging and cycling paths, playgrounds, and picnic areas. Visitors can relax by the waterfront, enjoy outdoor activities, and take in the scenic beauty of the park.", "https://myhktour.com/wp-content/uploads/2020/05/%E6%B7%B1%E5%9C%B3%E6%B9%BE%E5%85%AC%E5%9B%AD6.jpg");
       Attraction shenzhenGardenAndFlowerExpoPark = new Attraction("Shenzhen Garden and Flower Expo Park", shenzhen, "Shenzhen Garden and Flower Expo Park is a botanical garden and expo park located in the Longgang District of Shenzhen, China. It features a diverse collection of plants, flowers, and landscaped gardens, as well as pavilions, sculptures, and cultural exhibitions. Visitors can enjoy leisurely strolls, nature walks, and photography opportunities amidst the park's natural beauty.", "https://www.eyeshenzhen.com/pic/2019-03/22/7f605a67-c358-4e09-b3c6-acc7eb0428a2.jpg");
        Attraction dafenOilPaintingVillage = new Attraction("Dafen Oil Painting Village", shenzhen, "Dafen Oil Painting Village is an artists' village located in the Buji Subdistrict of Shenzhen, China. It is renowned for its thriving art community and production of high-quality oil paintings. Visitors can explore galleries, studios, and workshops, watch artists at work, and purchase original artworks or custom-made paintings.", "https://xiaoshuang198911.wordpress.com/wp-content/uploads/2014/02/e59bbee789874.png");

// Save attractions in Shenzhen
        attractionRepository.save(windowOfTheWorld);
        attractionRepository.save(shenzhenBayPark);
        attractionRepository.save(shenzhenGardenAndFlowerExpoPark);
        attractionRepository.save(dafenOilPaintingVillage);
// Top 5 attractions in Sydney
        Attraction sydneyHarbourBridge = new Attraction("Sydney Harbour Bridge", sydney, "The Sydney Harbour Bridge is an iconic steel through arch bridge across Sydney Harbour, connecting the Sydney central business district and the North Shore. It is one of the most famous landmarks in Sydney, offering breathtaking views of the harbor and city skyline. Visitors can climb the bridge for panoramic views or take a leisurely walk across the pedestrian walkway.", "");
        Attraction bondiBeach = new Attraction("Bondi Beach", sydney, "Bondi Beach is one of Australia's most famous beaches, located in the eastern suburbs of Sydney. It is known for its golden sand, clear waters, and iconic surf culture. Visitors can enjoy swimming, sunbathing, and surfing at Bondi Beach, as well as exploring the surrounding coastal walks, cafes, and boutiques.", "");
        Attraction royalBotanicGarden = new Attraction("Royal Botanic Garden", sydney, "The Royal Botanic Garden Sydney is a beautiful oasis located in the heart of Sydney, adjacent to the Sydney Opera House and Sydney Harbour Bridge. It features lush gardens, stunning waterfront views, and a diverse collection of plant species from around the world. Visitors can enjoy leisurely walks, guided tours, and picnics amidst the natural beauty of the garden.", "");
        Attraction tarongaZoo = new Attraction("Taronga Zoo", sydney, "Taronga Zoo is a world-renowned zoo located in Mosman, on the shores of Sydney Harbour. It is home to over 4,000 animals from around the world, including native Australian species such as kangaroos, koalas, and platypuses. Visitors can explore the zoo's exhibits, watch animal shows, and participate in behind-the-scenes experiences such as keeper talks and animal encounters.", "");
        Attraction sydneyTowerEye = new Attraction("Sydney Tower Eye", sydney, "Sydney Tower Eye is Sydney's tallest structure and a prominent feature of the city's skyline. It offers panoramic views of Sydney and its surroundings from its observation deck, located 250 meters above street level. Visitors can enjoy 360-degree views of the city, including landmarks such as the Sydney Opera House, Sydney Harbour Bridge, and Bondi Beach.", "");

// Save attractions in Sydney
        attractionRepository.save(sydneyHarbourBridge);
        attractionRepository.save(bondiBeach);
        attractionRepository.save(royalBotanicGarden);
        attractionRepository.save(tarongaZoo);
        attractionRepository.save(sydneyTowerEye);
// Top 5 attractions in Melbourne
        Attraction federationSquare = new Attraction("Federation Square", melbourne, "Federation Square is a cultural precinct located in the heart of Melbourne's central business district. It is known for its distinctive architecture, public spaces, and cultural attractions. Visitors can explore galleries, museums, and theaters, attend events and festivals, and enjoy dining and shopping in the square.", "");
        Attraction queenVictoriaMarket = new Attraction("Queen Victoria Market", melbourne, "Queen Victoria Market is a historic landmark and iconic shopping destination in Melbourne. It offers a wide range of fresh produce, gourmet foods, clothing, souvenirs, and handicrafts, as well as dining options and cultural events. Visitors can explore the market's bustling stalls, sample local delicacies, and soak up the vibrant atmosphere.", "");
        Attraction royalExhibitionBuilding = new Attraction("Royal Exhibition Building", melbourne, "The Royal Exhibition Building is a UNESCO World Heritage Site located in Carlton Gardens, Melbourne. It is one of the world's oldest remaining exhibition pavilions, known for its stunning architecture and historical significance. Visitors can take guided tours of the building, learn about its history and use, and admire its ornate interiors and decorative features.", "");
        Attraction melbourneZoo = new Attraction("Melbourne Zoo", melbourne, "Melbourne Zoo is a zoological garden located in Royal Park, Melbourne. It is home to a diverse collection of animals from around the world, including endangered species such as Sumatran tigers, orangutans, and gorillas. Visitors can explore the zoo's exhibits, attend animal presentations, and participate in behind-the-scenes experiences such as keeper talks and animal encounters.", "");
        Attraction nationalGalleryOfVictoria = new Attraction("National Gallery of Victoria", melbourne, "The National Gallery of Victoria is the oldest and largest public art museum in Australia, located in Melbourne. It features an extensive collection of artworks from around the world, including Australian Indigenous art, European masterpieces, Asian artifacts, and contemporary installations. Visitors can explore the gallery's permanent and temporary exhibitions, attend art talks and workshops, and enjoy guided tours and special events.", "");

// Save attractions in Melbourne
        attractionRepository.save(federationSquare);
        attractionRepository.save(queenVictoriaMarket);
        attractionRepository.save(royalExhibitionBuilding);
        attractionRepository.save(melbourneZoo);
        attractionRepository.save(nationalGalleryOfVictoria);
// Top 5 attractions in Brisbane
        Attraction southBankParklands = new Attraction("South Bank Parklands", brisbane, "South Bank Parklands is a premier recreational precinct located on the southern bank of the Brisbane River. It features lush gardens, sandy beaches, walking paths, playgrounds, and picnic areas. Visitors can enjoy swimming in the Streets Beach lagoon, exploring the Arbour promenade, visiting cultural institutions such as the Queensland Museum and Gallery of Modern Art, and dining at waterfront restaurants and cafes.", "");
        Attraction lonePineKoalaSanctuary = new Attraction("Lone Pine Koala Sanctuary", brisbane, "Lone Pine Koala Sanctuary is the world's first and largest koala sanctuary, located in the Brisbane suburb of Fig Tree Pocket. It is home to over 130 koalas, as well as a variety of other Australian wildlife, including kangaroos, wallabies, wombats, and emus. Visitors can cuddle koalas, hand-feed kangaroos, watch animal presentations and shows, and learn about Australian wildlife conservation.", "");
        Attraction storyBridgeAdventureClimb = new Attraction("Story Bridge Adventure Climb", brisbane, "The Story Bridge Adventure Climb offers a thrilling and unique experience to climb Brisbane's iconic Story Bridge. Participants are guided by experienced climb leaders as they ascend the bridge's steel structure, reaching heights of up to 80 meters above the Brisbane River. Along the way, climbers enjoy panoramic views of the city skyline, surrounding suburbs, and natural landmarks.", "");
        Attraction queenslandArtGallery = new Attraction("Queensland Art Gallery", brisbane, "The Queensland Art Gallery is one of Australia's leading art museums, located in the South Bank cultural precinct of Brisbane. It features an extensive collection of Australian and international art, including paintings, sculptures, decorative arts, and multimedia installations. Visitors can explore the gallery's permanent and temporary exhibitions, attend art workshops and events, and enjoy dining at the on-site cafe.", "");
        Attraction mtCootthaBotanicGardens = new Attraction("Mt Coot-tha Botanic Gardens", brisbane, "The Mt Coot-tha Botanic Gardens is a beautiful botanical garden located at the foot of Mt Coot-tha, just a short drive from Brisbane's city center. It features themed gardens, walking trails, picnic areas, and panoramic views of Brisbane and the surrounding areas. Visitors can explore the gardens' diverse plant collections, enjoy guided tours and workshops, and relax in tranquil natural surroundings.", "");

// Save attractions in Brisbane
        attractionRepository.save(southBankParklands);
        attractionRepository.save(lonePineKoalaSanctuary);
        attractionRepository.save(storyBridgeAdventureClimb);
        attractionRepository.save(queenslandArtGallery);
        attractionRepository.save(mtCootthaBotanicGardens);
// Top 5 attractions in Perth
        Attraction kingsParkAndBotanicGarden = new Attraction("Kings Park and Botanic Garden", perth, "Kings Park and Botanic Garden is one of the largest inner-city parks in the world, located on the western edge of Perth's central business district. It features expansive gardens, native bushland, walking trails, playgrounds, and picnic areas. Visitors can enjoy stunning views of the Swan River and Perth skyline, explore the park's biodiversity, and attend cultural events and festivals.", "");
        Attraction swanRiverCruise = new Attraction("Swan River Cruise", perth, "A Swan River Cruise is a scenic boat tour along the Swan River, offering picturesque views of Perth and its surrounding areas. Visitors can choose from a variety of cruise options, including sightseeing cruises, lunch and dinner cruises, and wine and beer tasting cruises. Along the way, passengers can admire iconic landmarks such as the Perth Mint, Old Swan Brewery, and Kings Park.", "");
        Attraction fremantlePrison = new Attraction("Fremantle Prison", perth, "Fremantle Prison is a UNESCO World Heritage Site located in Fremantle, just south of Perth. It is one of Western Australia's most significant historic landmarks, known for its well-preserved Victorian-era architecture and fascinating history as a former convict prison. Visitors can take guided tours of the prison, explore its cellblocks, gallows, and underground tunnels, and learn about the lives of convicts and prison guards.", "");
        Attraction cottesloeBeach = new Attraction("Cottesloe Beach", perth, "Cottesloe Beach is one of Perth's most popular and picturesque beaches, located in the western suburbs of the city. It features golden sands, clear turquoise waters, and stunning sunset views. Visitors can swim, sunbathe, surf, and snorkel at Cottesloe Beach, as well as enjoy beachside dining and cafes.", "");
        Attraction perthZoo = new Attraction("Perth Zoo", perth, "Perth Zoo is a zoological garden located in South Perth, just a short ferry ride from Perth's central business district. It is home to a diverse collection of animals from around the world, including native Australian species such as kangaroos, koalas, and wombats. Visitors can explore the zoo's exhibits, attend animal presentations and shows, and participate in behind-the-scenes experiences such as keeper talks and animal encounters.", "");

// Save attractions in Perth
        attractionRepository.save(kingsParkAndBotanicGarden);
        attractionRepository.save(swanRiverCruise);
        attractionRepository.save(fremantlePrison);
        attractionRepository.save(cottesloeBeach);
        attractionRepository.save(perthZoo);
// Top 5 attractions in Adelaide
        Attraction adelaideBotanicGarden = new Attraction("Adelaide Botanic Garden", adelaide, "Adelaide Botanic Garden is a beautiful botanical garden located in the heart of Adelaide, South Australia. It features lush gardens, exotic plant collections, and iconic landmarks such as the Palm House and Bicentennial Conservatory. Visitors can explore the garden's themed sections, enjoy guided tours and workshops, and relax in peaceful natural surroundings.", "");
        Attraction adelaideCentralMarket = new Attraction("Adelaide Central Market", adelaide, "Adelaide Central Market is a vibrant and bustling market located in the Adelaide city center. It is one of Australia's largest and oldest fresh produce markets, offering a wide range of fruits, vegetables, meats, cheeses, seafood, and gourmet foods. Visitors can explore the market's stalls, sample local delicacies, and experience the diverse flavors and aromas of South Australian cuisine.", "");
        Attraction adelaideZoo = new Attraction("Adelaide Zoo", adelaide, "Adelaide Zoo is a zoological park located in the parklands of Adelaide, South Australia. It is home to over 2,500 animals from around the world, including native Australian species such as kangaroos, koalas, and wombats. Visitors can explore the zoo's exhibits, attend animal presentations and shows, and participate in behind-the-scenes experiences such as keeper talks and animal encounters.", "");
        Attraction glenelgBeach = new Attraction("Glenelg Beach", adelaide, "Glenelg Beach is a popular seaside destination located just a short tram ride from Adelaide's city center. It features a sandy beach, calm waters, and a lively esplanade with cafes, restaurants, and shops. Visitors can swim, sunbathe, enjoy water sports, and take scenic walks along the beachfront promenade.", "");
        Attraction adelaideOval = new Attraction("Adelaide Oval", adelaide, "Adelaide Oval is a renowned sports stadium located in the parklands of Adelaide, South Australia. It is home to major sporting events such as cricket, Australian rules football, and rugby, as well as concerts and other entertainment events. Visitors can take guided tours of the stadium, learn about its history and architecture, and enjoy panoramic views of the playing field and city skyline.", "");

// Save attractions in Adelaide
        attractionRepository.save(adelaideBotanicGarden);
        attractionRepository.save(adelaideCentralMarket);
        attractionRepository.save(adelaideZoo);
        attractionRepository.save(glenelgBeach);
        attractionRepository.save(adelaideOval);
// Top 5 attractions in Bishkek
        Attraction alaArchaNationalPark = new Attraction("Ala Archa National Park", bishkek, "Ala Archa National Park is a picturesque mountainous area located just outside of Bishkek, the capital city of Kyrgyzstan. It offers stunning alpine landscapes, glacier-fed rivers, and diverse flora and fauna. Visitors can enjoy hiking, trekking, picnicking, and wildlife spotting amidst the park's natural beauty.", "");
        Attraction oshBazaar = new Attraction("Osh Bazaar", bishkek, "Osh Bazaar is one of the largest and most vibrant markets in Bishkek, offering a wide range of goods and products. Visitors can explore the market's stalls selling fresh produce, spices, textiles, clothing, souvenirs, and traditional Kyrgyz handicrafts. It is a bustling hub of activity and a great place to experience the local culture and atmosphere.", "");
        Attraction victorySquare = new Attraction("Victory Square", bishkek, "Victory Square is a central square located in the heart of Bishkek, Kyrgyzstan's capital city. It is dedicated to the victory of the Soviet Union in World War II and features a prominent statue of a woman holding a laurel wreath, symbolizing victory. Visitors can stroll around the square, admire the monument, and take in the surrounding architecture and cityscape.", "");
        Attraction stateHistoricalMuseum = new Attraction("State Historical Museum", bishkek, "The State Historical Museum is a cultural institution located in Bishkek, Kyrgyzstan. It showcases the history, culture, and heritage of Kyrgyzstan through a diverse collection of artifacts, exhibits, and displays. Visitors can learn about the country's ancient civilizations, nomadic tribes, and Soviet-era history, as well as its modern-day culture and society.", "");

// Save attractions in Bishkek
        attractionRepository.save(alaArchaNationalPark);
        attractionRepository.save(oshBazaar);
        attractionRepository.save(victorySquare);
        attractionRepository.save(stateHistoricalMuseum);
// Top 5 attractions in Osh
        Attraction leninPeak = new Attraction("Lenin Peak", osh, "Lenin Peak is one of the highest mountains in the Pamir range, located near the border between Kyrgyzstan and Tajikistan. It is a popular destination for mountaineers and adventure enthusiasts, offering challenging climbing routes and breathtaking views from its summit. Visitors can trek to base camps at the foot of the mountain or join guided expeditions to attempt the summit.", "");
        Attraction oshRegionalMuseum = new Attraction("Osh Regional Museum", osh, "The Osh Regional Museum is a cultural institution located in Osh, Kyrgyzstan. It showcases the history, culture, and heritage of the Osh region through a diverse collection of artifacts, exhibits, and displays. Visitors can learn about the region's ancient civilizations, nomadic tribes, and Silk Road heritage, as well as its modern-day culture and society.", "");
        Attraction jalaAbadBazaar = new Attraction("Jalal-Abad Bazaar", osh, "Jalal-Abad Bazaar is a bustling market located in the city of Jalal-Abad, Kyrgyzstan. It offers a wide range of goods and products, including fresh produce, spices, textiles, clothing, household items, and souvenirs. Visitors can explore the market's stalls, shop for local goods, and experience the vibrant atmosphere of Jalal-Abad's trading culture.", "");

// Save attractions in Osh
        attractionRepository.save(leninPeak);
        attractionRepository.save(oshRegionalMuseum);
        attractionRepository.save(jalaAbadBazaar);


// Top Attractions for Riyadh
        Attraction kingdomCentreTower = new Attraction("Kingdom Centre Tower", riyadh, "The Kingdom Centre Tower is one of Riyadh's most iconic landmarks, soaring over the city's skyline with its distinctive design. It houses luxury apartments, offices, and a shopping mall, but the highlight is the Sky Bridge, an observation deck offering panoramic views of Riyadh. Visitors can enjoy breathtaking vistas of the city and beyond from this vantage point.", "https://d6qyz3em3b312.cloudfront.net/upload/images/media/2019/10/01/shutterstock_1224851173.2048x1024.jpg");
        Attraction alMasmakFortress = new Attraction("Al-Masmak Fortress", riyadh, "Al-Masmak Fortress is a historic castle located in the heart of Riyadh, dating back to the 19th century. It played a significant role in the founding of the Kingdom of Saudi Arabia, serving as a symbol of resistance during the Riyadh Reconquest. Today, the fortress has been transformed into a museum, showcasing exhibits on Saudi heritage, culture, and history.", "https://welcomesaudi.com/uploads/0000/1/2021/07/23/9-al-masmak-palace-museum-riyadh-province.jpg");
        Attraction nationalMuseumOfSaudiArabia = new Attraction("National Museum of Saudi Arabia", riyadh, "The National Museum of Saudi Arabia is a cultural institution in Riyadh dedicated to preserving and promoting the history, heritage, and traditions of Saudi Arabia. It features a vast collection of artifacts, manuscripts, and archaeological finds spanning thousands of years, from prehistoric times to the present day. Visitors can explore exhibits on ancient civilizations, Islamic art, Saudi folklore, and more, offering insights into the kingdom's rich cultural tapestry.", "https://scth.scene7.com/is/image/scth/the-national-museum-of-saudi-arabia-desktop-1:crop-760x570?defaultImage=the-national-museum-of-saudi-arabia-desktop-1");
        Attraction edgeOfTheWorld = new Attraction("Edge of the World", riyadh, "The Edge of the World is a dramatic escarpment located just outside Riyadh, offering breathtaking views of the surrounding desert landscape. It is a popular destination for outdoor enthusiasts, hikers, and nature lovers seeking adventure and solitude. Visitors can hike along the rugged terrain, marvel at the sheer cliffs and rock formations, and witness stunning sunsets over the horizon.", "https://static1.thetravelimages.com/wordpress/wp-content/uploads/2022/11/Edge-of-the-World-Riyadh-Saudi-Arabia-1.JPG");
        Attraction diriyahHistoricalQuarter = new Attraction("Diriyah Historical Quarter", riyadh, "Diriyah Historical Quarter is a UNESCO World Heritage Site located on the outskirts of Riyadh, comprising ancient palaces, mosques, and traditional mud-brick houses. It was the original seat of the Saudi royal family and the capital of the first Saudi state. Today, the quarter has been restored and transformed into a cultural and historical attraction, allowing visitors to step back in time and experience Saudi Arabia's rich heritage and architecture.", "https://upload.wikimedia.org/wikipedia/commons/4/49/At-Turaif_District_of_Diriyah%2C_Saudi_Arabia.jpg");

        attractionRepository.save(kingdomCentreTower);
        attractionRepository.save(alMasmakFortress);
        attractionRepository.save(nationalMuseumOfSaudiArabia);
        attractionRepository.save(edgeOfTheWorld);
        attractionRepository.save(diriyahHistoricalQuarter);

// Top Attractions for Jeddah
        Attraction alBaladHistoricDistrict = new Attraction("Al-Balad Historic District", jeddah, "Al-Balad Historic District is the old town of Jeddah, renowned for its traditional architecture, historic buildings, and bustling souks. It is a UNESCO World Heritage Site, preserving the rich cultural heritage of Jeddah's past. Visitors can wander through its labyrinthine streets, admire the intricately decorated houses known as 'coral homes,' and explore the vibrant markets selling everything from spices to textiles.", "https://www.thenationalnews.com/resizer/hgZRkVfxzSQlfnZMM6tCCVIhhdg=/arc-photo-thenational/eu-central-1-prod/public/RFY3MEI7ESNI3SDD4LVPNYPF6M.jpg");
        Attraction kingFahdFountain = new Attraction("King Fahd Fountain", jeddah, "The King Fahd Fountain, also known as the Jeddah Fountain, is one of the tallest fountains in the world, located on the coast of Jeddah's Corniche. It shoots water jets up to 312 meters high, creating a spectacular display that can be seen from miles away. Visitors can enjoy leisurely strolls along the Corniche promenade and admire the fountain's mesmerizing nighttime illumination.", "https://destinationksa.com/wp-content/uploads/2015/10/22.jpg");
        Attraction coralReefDiving = new Attraction("Coral Reef Diving", jeddah, "Jeddah is renowned for its pristine coral reefs and vibrant marine life, making it a popular destination for scuba diving and snorkeling enthusiasts. The city's coastline is dotted with numerous dive sites, offering opportunities to explore colorful coral gardens, encounter exotic fish species, and even spot sea turtles and rays. Visitors can embark on diving excursions led by experienced guides to discover the underwater wonders of the Red Sea.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT9qQHa4m0OMldwvm8VV8JtNq_3ZsiPC4csA&s");
        Attraction redSeaMall = new Attraction("Red Sea Mall", jeddah, "Red Sea Mall is one of the largest shopping malls in Jeddah, offering a wide range of retail outlets, dining options, and entertainment facilities. It features luxury boutiques, international brands, and a diverse food court, catering to all tastes and preferences. Visitors can shop for designer fashion, electronics, cosmetics, and souvenirs, or simply enjoy a day of leisure and recreation with family and friends.", "https://ik.imagekit.io/mecsrweb/images/uploads/news-pictures/27-dubai-blog-post-image-20230406101815.jpg");

        attractionRepository.save(alBaladHistoricDistrict);
        attractionRepository.save(kingFahdFountain);
        attractionRepository.save(coralReefDiving);
        attractionRepository.save(redSeaMall);

// Top Attractions for Mecca
        Attraction alMasjidAlHaram = new Attraction("Al-Masjid al-Haram", mecca, "Al-Masjid al-Haram, also known as the Grand Mosque, is the holiest site in Islam and the largest mosque in the world. It surrounds the Kaaba, the cubic structure towards which Muslims around the world face during their prayers. Millions of pilgrims visit the mosque every year, especially during the Hajj pilgrimage, to perform religious rituals and seek spiritual blessings. The mosque's magnificent architecture and historical significance make it a symbol of unity and devotion for Muslims worldwide.", "https://www.rjtravelagency.com/wp-content/uploads/2023/03/Al-Masjid-al-Haram-The-Holy-Mosque-7.jpg");
        Attraction mountArafat = new Attraction("Mount Arafat", mecca, "Mount Arafat, also known as Jabal al-Rahmah (the Mount of Mercy), is a granite hill located near Mecca, Saudi Arabia. It is a significant site for Muslims, as it is where the Prophet Muhammad delivered his Farewell Sermon during his final pilgrimage (Hajj). Pilgrims performing the Hajj gather at Mount Arafat on the ninth day of the Islamic month of Dhu al-Hijjah to engage in prayers and supplications, following the tradition set by the Prophet Muhammad.", "https://cdnuploads.aa.com.tr/uploads/Contents/2018/08/20/thumbs_b_c_be05170d22e353055276545a597f4a6f.jpg?v=123147");
        Attraction jabalAlNour = new Attraction("Jabal al-Nour", mecca, "Jabal al-Nour, meaning the 'Mountain of Light,' is a mountain located near Mecca, Saudi Arabia. It is famous for the Cave of Hira, where the Prophet Muhammad received the first revelation of the Quran from the Angel Gabriel. Pilgrims and visitors often hike up the mountain to visit the cave and reflect on its historical significance in Islam. The ascent offers panoramic views of Mecca and its surroundings, providing a spiritual and serene experience for believers.", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/%D8%AC%D8%A8%D9%84_%D8%A7%D9%84%D9%86%D9%88%D8%B1_%D9%85%D9%83%D8%A9.jpg/277px-%D8%AC%D8%A8%D9%84_%D8%A7%D9%84%D9%86%D9%88%D8%B1_%D9%85%D9%83%D8%A9.jpg");

        attractionRepository.save(alMasjidAlHaram);
        attractionRepository.save(mountArafat);
        attractionRepository.save(jabalAlNour);

// Top Attractions for Medina
        Attraction alMasjidAnNabawi = new Attraction("Al-Masjid an-Nabawi", medina, "Al-Masjid an-Nabawi, also known as the Prophet's Mosque, is the second holiest site in Islam and one of the largest mosques in the world. It is located in the city of Medina, Saudi Arabia, and contains the tomb of the Prophet Muhammad. Pilgrims and visitors flock to the mosque to offer prayers, pay their respects to the Prophet Muhammad, and seek blessings. The mosque's green dome and minarets are iconic symbols of Medina's skyline, attracting millions of worshippers and tourists each year.", "");
        Attraction qubaMosque = new Attraction("Quba Mosque", medina, "Quba Mosque is the first mosque built by the Prophet Muhammad in Medina, Saudi Arabia, and holds significant religious importance in Islam. It is located on the outskirts of Medina and is considered the oldest mosque in the world. Muslims visit Quba Mosque to perform prayers and seek blessings, believing that praying in the mosque carries great rewards. The mosque's simple yet elegant architecture and tranquil surroundings make it a serene and spiritual destination for worshippers and visitors alike.", "");
        Attraction mountUhud = new Attraction("Mount Uhud", medina, "Mount Uhud is a mountain range located north of Medina, Saudi Arabia, notable for its historical significance in Islamic history. It was the site of the Battle of Uhud, a key battle fought between the early Muslims of Medina and the Quraysh tribe of Mecca. Pilgrims and visitors often climb Mount Uhud to explore its rugged terrain, visit the site of the battle, and reflect on its lessons of bravery and sacrifice. The mountain offers panoramic views of the city of Medina and its surrounding landscapes, providing a peaceful and contemplative experience for visitors.", "");
        Attraction alBaqiCemetery = new Attraction("Al-Baqi' Cemetery", medina, "Al-Baqi' Cemetery is an ancient burial ground located near Al-Masjid an-Nabawi in Medina, Saudi Arabia. It is the final resting place of many prominent figures in Islamic history, including several companions of the Prophet Muhammad and members of his family. Pilgrims and visitors pay their respects to the deceased, recite prayers, and contemplate the transient nature of life. The cemetery's serene atmosphere and historical significance make it a sacred and contemplative site for Muslims.", "");
        Attraction datesMarket = new Attraction("Dates Market", medina, "The Dates Market in Medina is a bustling marketplace known for its wide variety of dates, a staple fruit in the Middle East. It offers an array of dates sourced from local farms and orchards, including premium varieties such as Ajwa and Sukkari. Visitors can sample different types of dates, purchase them as souvenirs, or enjoy traditional date-based sweets and snacks. The market's vibrant atmosphere and aromatic scents make it a popular destination for locals and tourists alike.", "");

        attractionRepository.save(alMasjidAnNabawi);
        attractionRepository.save(qubaMosque);
        attractionRepository.save(mountUhud);
        attractionRepository.save(alBaqiCemetery);
        attractionRepository.save(datesMarket);

// Top Attractions for Dammam
        Attraction corniche = new Attraction("Dammam Corniche", dammam, "The Dammam Corniche is a picturesque waterfront promenade that stretches along the coast of Dammam, Saudi Arabia. It offers stunning views of the Arabian Gulf, with landscaped gardens, walking paths, and recreational areas for visitors to enjoy. The corniche is a popular destination for families, joggers, and couples seeking leisure and relaxation by the sea. Visitors can take in the sea breeze, watch the sunset, or indulge in waterfront dining at one of the many cafes and restaurants.", "");
        Attraction kingAbdulazizCenterForWorldCulture = new Attraction("King Abdulaziz Center for World Culture", dammam, "The King Abdulaziz Center for World Culture, also known as Ithra, is a cultural complex located in Dammam, Saudi Arabia. It serves as a hub for arts, education, and innovation, offering a diverse range of programs and activities for visitors of all ages. The center features state-of-the-art facilities, including theaters, galleries, libraries, and interactive exhibits, showcasing Saudi Arabia's cultural heritage and fostering creativity and learning. Visitors can attend performances, workshops, and exhibitions, making it a vibrant cultural destination in Dammam.", "");
        Attraction alDanahMall = new Attraction("Al Danah Mall", dammam, "Al Danah Mall is a modern shopping destination located in the heart of Dammam, Saudi Arabia. It offers a wide range of retail stores, international brands, and entertainment facilities, catering to shoppers of all ages and interests. The mall features spacious atriums, stylish boutiques, and a variety of dining options, making it a popular spot for leisurely shopping and socializing. Visitors can shop for fashion, electronics, cosmetics, and more, or enjoy family-friendly activities such as cinema screenings and indoor playgrounds.", "");
        Attraction marjanIsland = new Attraction("Marjan Island", dammam, "Marjan Island is a man-made island located off the coast of Dammam, Saudi Arabia, offering a tranquil retreat from the city's hustle and bustle. It features pristine beaches, lush green spaces, and recreational facilities for visitors to enjoy. The island is a popular destination for picnics, water sports, and beachside relaxation, with designated areas for swimming, sunbathing, and beach volleyball. Visitors can escape the urban landscape and immerse themselves in the natural beauty and serenity of Marjan Island.", "");
        Attraction alShateaMall = new Attraction("Al Shatea Mall", dammam, "Al Shatea Mall is a popular shopping and entertainment complex located in Dammam, Saudi Arabia. It offers a diverse range of retail outlets, dining options, and recreational activities for visitors of all ages. The mall features international and local brands, a food court with various cuisines, and entertainment facilities such as cinemas and amusement arcades. Visitors can shop, dine, and socialize in a vibrant and dynamic environment, making it a favorite destination for locals and tourists alike.", "");

        attractionRepository.save(corniche);
        attractionRepository.save(kingAbdulazizCenterForWorldCulture);
        attractionRepository.save(alDanahMall);
        attractionRepository.save(marjanIsland);
        attractionRepository.save(alShateaMall);

// Top Attractions for Muscat
        Attraction sultanQaboosGrandMosque = new Attraction("Sultan Qaboos Grand Mosque", muscat, "The Sultan Qaboos Grand Mosque is one of the most iconic landmarks in Muscat, Oman, known for its stunning architecture and grandeur. It features a magnificent main prayer hall, adorned with a massive chandelier, intricately designed carpets, and marble walls with intricate Islamic patterns. The mosque's exterior is equally impressive, with its distinctive domes, minarets, and expansive courtyard. Visitors can explore the mosque's interior, marvel at its beauty, and learn about Omani culture and Islamic architecture.", "");
        Attraction muttrahSouq = new Attraction("Muttrah Souq", muscat, "Muttrah Souq is a bustling marketplace located in the heart of Muscat, Oman, offering a wide array of goods and merchandise. It is one of the oldest souqs in the country, dating back over two centuries, and retains its traditional charm and atmosphere. Visitors can wander through its narrow alleyways, browse through stalls selling spices, textiles, jewelry, and handicrafts, and haggle with friendly shopkeepers. The souq is also a great place to experience Omani culture, taste local delicacies, and shop for souvenirs.", "");
        Attraction royalOperaHouseMuscat = new Attraction("Royal Opera House Muscat", muscat, "The Royal Opera House Muscat is a prestigious cultural institution and performing arts venue located in Muscat, Oman. It showcases a diverse program of opera, ballet, classical music, theater, and dance performances, featuring both local talent and international artists. The opera house is renowned for its stunning architecture, blending traditional Omani design elements with modern amenities. Visitors can attend world-class performances, guided tours, and educational workshops, making it a must-visit destination for arts and culture enthusiasts in Muscat.", "");
        Attraction alRiyamPark = new Attraction("Al Riyam Park", muscat, "Al Riyam Park is a scenic park located along the coastline of Muscat, Oman, offering panoramic views of the city's skyline and the Arabian Sea. It features lush greenery, walking trails, and recreational facilities for visitors to enjoy. The park is home to several iconic landmarks, including the giant incense burner monument and the Omani French Museum. Visitors can relax in the park's tranquil setting, take in the stunning views, and capture memorable photos of Muscat's picturesque coastline.", "");
        Attraction bimmahSinkhole = new Attraction("Bimmah Sinkhole", muscat, "Bimmah Sinkhole, also known as Hawiyat Najm Park, is a natural wonder located near Muscat, Oman, formed by the collapse of limestone bedrock. It is filled with turquoise-blue water and surrounded by rocky cliffs, creating a breathtaking sight. The sinkhole is a popular swimming and picnic spot for locals and tourists, offering crystal-clear waters and stunning views of the surrounding landscape. Visitors can swim, snorkel, or simply admire the beauty of this natural marvel, making it a must-visit destination for nature lovers in Muscat.", "");

        attractionRepository.save(sultanQaboosGrandMosque);
        attractionRepository.save(muttrahSouq);
        attractionRepository.save(royalOperaHouseMuscat);
        attractionRepository.save(alRiyamPark);
        attractionRepository.save(bimmahSinkhole);

// Top Attractions for Doha
        Attraction thePearlQatar = new Attraction("The Pearl-Qatar", doha, "The Pearl-Qatar is an artificial island and luxury residential development located off the coast of Doha, Qatar. It features upscale residences, high-end shopping boutiques, fine dining restaurants, and luxury hotels, all surrounding a marina with yachts and boats. Visitors can stroll along the picturesque promenade, enjoy waterfront dining, shop for designer brands, and admire the stunning architecture and views of the Arabian Gulf.", "");
        Attraction souqWaqif = new Attraction("Souq Waqif", doha, "Souq Waqif is a vibrant traditional market in the heart of Doha, Qatar, known for its bustling atmosphere, maze-like alleyways, and diverse range of products. It offers a variety of goods, including spices, textiles, traditional garments, handicrafts, and souvenirs. Visitors can explore the souq's narrow lanes, interact with local vendors, and experience Qatari culture and heritage. Souq Waqif also features numerous cafes, restaurants, and shisha lounges, where visitors can relax and enjoy authentic Arabian cuisine.", "");
        Attraction museumOfIslamicArt = new Attraction("Museum of Islamic Art", doha, "The Museum of Islamic Art is a world-class cultural institution located on the Corniche waterfront in Doha, Qatar. It houses one of the most extensive collections of Islamic art in the world, spanning over 1,400 years and three continents. The museum's stunning architecture, designed by renowned architect I. M. Pei, and its rich collection of artifacts, including ceramics, textiles, manuscripts, and metalwork, make it a must-visit destination for art and history enthusiasts.", "");
        Attraction aspirePark = new Attraction("Aspire Park", doha, "Aspire Park is a sprawling green oasis located in the heart of Doha, Qatar, adjacent to the Aspire Zone sports complex. It is one of the largest parks in the country, featuring lush landscaped gardens, walking paths, playgrounds, and recreational facilities. Visitors can enjoy picnics, leisurely strolls, and outdoor activities, with scenic views of the Aspire Tower and the surrounding skyline. Aspire Park is a popular destination for families, fitness enthusiasts, and nature lovers seeking relaxation and tranquility amidst the urban landscape.", "");
        Attraction kataraCulturalVillage = new Attraction("Katara Cultural Village", doha, "Katara Cultural Village is a cultural hub and entertainment precinct located on the eastern coast of Doha, Qatar. It celebrates Qatar's heritage and multiculturalism through various cultural, artistic, and educational initiatives. The village features theaters, galleries, museums, restaurants, and outdoor performance spaces, hosting a diverse range of events and festivals throughout the year. Visitors can explore exhibitions, attend concerts, watch theatrical performances, and participate in workshops, offering insights into Qatari culture and traditions.", "");

        attractionRepository.save(thePearlQatar);
        attractionRepository.save(souqWaqif);
        attractionRepository.save(museumOfIslamicArt);
        attractionRepository.save(aspirePark);
        attractionRepository.save(kataraCulturalVillage);

// Top Attractions for Lusail
        Attraction lusailIconicStadium = new Attraction("Lusail Iconic Stadium", lusail, "Lusail Iconic Stadium is a state-of-the-art sports venue located in Lusail, Qatar, designed to host matches during the FIFA World Cup. It features a striking architectural design inspired by traditional Arab architectural elements, with a capacity to seat over 80,000 spectators. The stadium is equipped with modern facilities, including hospitality suites, VIP lounges, and media centers, ensuring a world-class experience for visitors and participants alike.", "");
        Attraction lusailMarinaPromenade = new Attraction("Lusail Marina Promenade", lusail, "Lusail Marina Promenade is a scenic waterfront promenade located along the coastline of Lusail, Qatar. It offers panoramic views of the marina, with luxury yachts, sailing boats, and waterfront cafes lining the promenade. Visitors can stroll along the boardwalk, enjoy alfresco dining, and admire the stunning sunset over the Arabian Gulf. The promenade is a popular destination for leisure and recreation, with landscaped gardens, jogging tracks, and outdoor seating areas.", "");
        Attraction lusailTowers = new Attraction("Lusail Towers", lusail, "Lusail Towers is a mixed-use development located in Lusail, Qatar, comprising several high-rise buildings that form the centerpiece of the city's skyline. It includes residential towers, commercial offices, retail outlets, and luxury hotels, all connected by pedestrian-friendly promenades and plazas. The towers feature modern architecture, innovative design elements, and panoramic views of the surrounding cityscape and waterfront. Visitors can explore the towers, dine at upscale restaurants, and shop at designer boutiques, experiencing the epitome of luxury and sophistication in Lusail.", "");
        Attraction lusailLightRailTransit = new Attraction("Lusail Light Rail Transit", lusail, "Lusail Light Rail Transit (LRT) is a modern tram system that serves the city of Lusail, Qatar, providing efficient and sustainable transportation for residents and visitors. The LRT network connects key destinations within Lusail, including residential areas, commercial districts, and leisure attractions, with comfortable and convenient tram services. Visitors can ride the LRT to explore Lusail's landmarks, shopping centers, and entertainment venues, enjoying scenic views of the city along the way.", "");
        Attraction lusailNationalMuseum = new Attraction("Lusail National Museum", lusail, "Lusail National Museum is a cultural institution located in Lusail, Qatar, dedicated to showcasing the history, heritage, and future vision of the city. It features interactive exhibits, multimedia displays, and immersive experiences that highlight Lusail's development as a modern metropolis. The museum's architecture reflects Qatari design motifs and sustainable principles, with innovative technologies and environmentally friendly features integrated throughout the building. Visitors can learn about Lusail's urban planning, architectural landmarks, and cultural landmarks, gaining insights into the city's past, present, and future.", "");

        attractionRepository.save(lusailIconicStadium);
        attractionRepository.save(lusailMarinaPromenade);
        attractionRepository.save(lusailTowers);
        attractionRepository.save(lusailLightRailTransit);
        attractionRepository.save(lusailNationalMuseum);

// Top Attractions for Bangkok
        Attraction chatuchakWeekendMarket = new Attraction("Chatuchak Weekend Market", bangkok, "Chatuchak Weekend Market is one of the largest and most popular markets in Bangkok, Thailand, offering a vast array of goods and merchandise. It spans over 35 acres and features thousands of stalls selling everything from clothing and accessories to handicrafts, antiques, and souvenirs. The market is a treasure trove for bargain hunters and shoppers, with a diverse range of products at affordable prices. Visitors can wander through its maze-like alleyways, sample local snacks, and immerse themselves in the vibrant atmosphere of this bustling marketplace.", "");
        Attraction floatingMarkets = new Attraction("Floating Markets", bangkok, "Floating markets are a unique and traditional feature of Bangkok, Thailand, where vendors sell goods from boats along the city's canals and rivers. There are several floating markets in and around Bangkok, each offering its own distinct charm and atmosphere. Visitors can explore the markets by boat, browse through stalls selling fresh produce, local snacks, and handicrafts, and experience the vibrant sights, sounds, and flavors of Thai culture. Floating markets provide an authentic glimpse into Bangkok's rich culinary and trading heritage, making them a popular attraction for tourists.", "");
        Attraction lumpiniPark = new Attraction("Lumpini Park", bangkok, "The oldest park in the city.", "");
        Attraction jimThompsonHouse = new Attraction("Jim Thompson house", bangkok, "This former home of an American named Jim Thompson, who started the Thai silk industry after World War II, houses a magnificent collection of Asian art and many unique displays.", "");
        Attraction centralWorld = new Attraction("Central Word", bangkok, "This massive shopping complex in Bangkok houses over 500 stores across seven floors. CentralWorld is also connected to a 5-star hotel, a 15-screen cinema, and an ice skating rink—great for a family outing. For avid shoppers, expect designer brands as well as leading international and local fashion brands. When hungry, don’t miss the Central Food Hall and the array of restaurants, cafes, and dessert joints in the mall. Tourists can obtain a special discount card with their passports and enjoy even more savings. CentralWorld can be easily reached by the BTS Skytrain.", "");

        attractionRepository.save(chatuchakWeekendMarket);
        attractionRepository.save(floatingMarkets);
        attractionRepository.save(lumpiniPark);
        attractionRepository.save(jimThompsonHouse);
        attractionRepository.save(centralWorld);

// Top Attractions for Chiang Mai
        Attraction nightBazaar = new Attraction("Night Bazaar", chiangMai, "Chiang Mai Night Bazaar is a bustling market that comes to life after sunset, offering a lively and vibrant shopping experience. It spans several blocks along Chang Khlan Road and features hundreds of stalls selling a variety of goods, including clothing, handicrafts, souvenirs, and street food. Visitors can browse through the stalls, haggle with vendors, and sample local snacks while soaking in the energetic atmosphere. The Night Bazaar is also known for its live music performances, cultural shows, and entertainment, making it a must-visit destination for tourists in Chiang Mai.", "");
        Attraction chiangMaiElephantNaturePark = new Attraction("Chiang Mai Elephant Nature Park", chiangMai, "Chiang Mai Elephant Nature Park is an ethical elephant sanctuary located in the outskirts of Chiang Mai, Thailand, dedicated to the rescue and conservation of elephants. It provides a natural and humane environment for rescued elephants to roam freely, socialize, and rehabilitate after years of mistreatment in the tourism and logging industries. Visitors can experience close encounters with elephants, feed them, and observe their natural behaviors in their natural habitat. The park also offers educational programs and volunteer opportunities, allowing visitors to learn about elephant welfare and contribute to conservation efforts.", "");

        attractionRepository.save(nightBazaar);
        attractionRepository.save(chiangMaiElephantNaturePark);

// Top Attractions for Phuket
        Attraction patongBeach = new Attraction("Patong Beach", phuket, "Patong Beach is one of Phuket's most popular beaches, known for its vibrant atmosphere, golden sands, and crystal-clear waters. Visitors can enjoy a wide range of water sports and activities, including swimming, snorkeling, and jet skiing, or simply relax on the beach and soak up the sun. The beach is also lined with restaurants, bars, and shops, offering plenty of dining and entertainment options day and night.", "");
        Attraction phiPhiIslands = new Attraction("Phi Phi Islands", phuket, "The Phi Phi Islands are a group of picturesque islands located off the coast of Phuket, Thailand. Known for their stunning natural beauty, turquoise waters, and vibrant marine life, the islands are a popular destination for snorkeling, diving, and island hopping tours. Visitors can explore attractions such as Maya Bay, where the movie 'The Beach' was filmed, as well as enjoy swimming, sunbathing, and beach picnics on the islands' pristine beaches.", "");
        Attraction oldPhuketTown = new Attraction("Old Phuket Town", phuket, "Old Phuket Town is the historic heart of Phuket, known for its colorful Sino-Portuguese buildings, vibrant street art, and cultural attractions. Visitors can wander through its charming streets, lined with quaint cafes, boutique shops, and art galleries, and admire the architecture and street murals. The area also features historic landmarks such as Thalang Road and Soi Rommanee, as well as museums, and markets showcasing Phuket's rich cultural heritage.", "");
        Attraction similanIslandsNationalPark = new Attraction("Similan Islands National Park", phuket, "Similan Islands National Park is a group of stunning islands located off the coast of Phang Nga Province, near Phuket, Thailand. Known for their crystal-clear waters, vibrant coral reefs, and diverse marine life, the Similan Islands are a paradise for snorkeling, diving, and beach lovers. Visitors can explore pristine beaches, hike through lush forests, and swim alongside colorful fish and sea turtles in the park's protected marine areas. The islands are also home to scenic viewpoints, hiking trails, and camping sites, offering opportunities for adventure and relaxation amidst the beauty of nature.", "");

        attractionRepository.save(patongBeach);
        attractionRepository.save(phiPhiIslands);
        attractionRepository.save(oldPhuketTown);
        attractionRepository.save(similanIslandsNationalPark);



// Top Attractions for Kuala Lumpur
        Attraction petronasTwinTowers = new Attraction("Petronas Twin Towers", kualaLumpur, "The Petronas Twin Towers are an iconic landmark and symbol of Kuala Lumpur, Malaysia. Standing at 451.9 meters tall, they were once the tallest buildings in the world. Visitors can admire the towers' impressive architecture, take a guided tour to learn about their construction and history, and enjoy panoramic views of the city skyline from the observation deck on the 86th floor. The towers are also surrounded by a beautifully landscaped park with fountains and walking paths, making them a must-visit attraction for tourists.", "https://img.veenaworld.com/wp-content/uploads/2021/09/Petronas-Twin-Tower-Malaysia-Timing-Location-and-Things-to-Do-scaled.jpg");
        Attraction kualaLumpurTower = new Attraction("Kuala Lumpur Tower", kualaLumpur, "The Kuala Lumpur Tower, also known as Menara KL, is a telecommunications tower and iconic landmark in Kuala Lumpur, Malaysia. Standing at 421 meters tall, it offers panoramic views of the city skyline from its observation deck and revolving restaurant. Visitors can take high-speed elevators to the top, where they can enjoy breathtaking views of Kuala Lumpur and its surrounding landscapes. The tower also features a variety of attractions, including a cultural village, souvenir shops, and an amphitheater, making it a popular destination for tourists and locals alike.", "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcS7b-Y7Dat3VxSGu3x0CsHRlEWJc97WmPBMRAc1tXIdEfov2z3YzLR3jhXhZlJ2v78sKOrVLpyBldvJQjBpKiEzBA9TLEy983SVOvsG7g");
        Attraction centralMarket = new Attraction("Central Market", kualaLumpur, "Central Market is a cultural and heritage landmark located in the heart of Kuala Lumpur, Malaysia. Built-in 1928, it is one of the city's oldest markets and a popular destination for arts, crafts, and Malaysian souvenirs. Visitors can explore the market's bustling stalls, which offer a wide range of items, including batik fabrics, traditional handicrafts, and local snacks. The market also hosts cultural performances, art exhibitions, and workshops, providing visitors with opportunities to learn about Malaysian culture and traditions.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/13/8c/99/41/central-market.jpg?w=1200&h=-1&s=1");
        Attraction kualaLumpurBirdPark = new Attraction("Kuala Lumpur Bird Park", kualaLumpur, "The Kuala Lumpur Bird Park is the largest covered bird park in the world and a popular tourist attraction in Kuala Lumpur, Malaysia. Spanning 20.9 acres, it is home to over 3,000 birds from more than 200 species, including rare and endangered birds. Visitors can explore the park's aviaries, walk-through exhibits, and landscaped gardens, where they can observe birds in their natural habitats and participate in feeding sessions and bird shows. The park also offers educational programs and guided tours, making it a fun and educational experience for visitors of all ages.", "https://d15ldvyocwqu5y.cloudfront.net/images/uploaded-new/285402");

        attractionRepository.save(petronasTwinTowers);
        attractionRepository.save(kualaLumpurTower);
        attractionRepository.save(centralMarket);
        attractionRepository.save(kualaLumpurBirdPark);

// Top Attractions for George Town
        Attraction penangHill = new Attraction("Penang Hill", georgeTown, "Penang Hill, also known as Bukit Bendera, is a hill resort located in George Town, Penang, Malaysia. It offers panoramic views of the city skyline and surrounding landscapes from its peak, which stands at 833 meters above sea level. Visitors can reach the top by taking the Penang Hill Railway, a funicular railway that has been in operation since 1923. At the summit, visitors can explore attractions such as the Owl Museum, Monkey Cup Garden, and historical colonial bungalows. Penang Hill is also a popular destination for hiking, nature walks, and birdwatching, offering visitors a serene retreat amidst the lush tropical rainforest.", "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcSE2RlKMNRJ4KP9jglrjbYO8aNcrV5cMKUZu3wH7-IUuHSP7BnLhuka3pzCLwkxGQ1SBrMFNCEPey5InzhC0u8GUFxfRaBRFRalVwiQfQ");
        Attraction streetArt = new Attraction("Street Art", georgeTown, "George Town is renowned for its vibrant street art scene, featuring colorful murals and installations by local and international artists. Visitors can explore the city's streets and alleys to discover these artworks, which depict scenes from Penang's rich cultural heritage, history, and everyday life. Some of the most famous murals include 'Children on Bicycle', 'Little Children on a Bicycle', and 'Boy on a Bike'. George Town's street art adds character and charm to the city's urban landscape, making it a popular destination for art lovers, photographers, and cultural enthusiasts.", "https://nerdnomads.com/wp-content/uploads/2019/03/Cat-mural-george-town-penang-800x534.jpg");
        Attraction penangPeranakanMansion = new Attraction("Penang Peranakan Mansion", georgeTown, "The Penang Peranakan Mansion is a museum located in George Town, Penang, Malaysia, showcasing the rich heritage and culture of the Peranakan community. Housed in a beautifully restored colonial mansion, the museum features a vast collection of antiques, artifacts, and memorabilia from the Peranakan era, including furniture, ceramics, jewelry, and clothing. Visitors can explore the mansion's opulent interiors, learn about Peranakan customs and traditions, and admire the intricate craftsmanship and design of the era. The Penang Peranakan Mansion offers a fascinating glimpse into the unique blend of Chinese, Malay, and European influences that characterize Peranakan culture.", "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSlZo_ghkzuKa8X9SHaI8L9rRMtbghGgk1veHDW5-OEHXQwfTxQKvKI6jIXm3jB3f5EwZrQPwi5fNsLarveI_Nb1zd4Yp76XTsW9CUW6A");
        Attraction penangButterflyFarm = new Attraction("Penang Butterfly Farm", georgeTown, "The Penang Butterfly Farm is a tropical butterfly sanctuary located in Teluk Bahang, Penang, Malaysia, just outside of George Town. Spanning over 0.8 hectares, it is home to thousands of butterflies from over 120 species, as well as other insects and reptiles. Visitors can explore the farm's lush gardens, walk-through exhibits, and educational displays, where they can observe butterflies in various stages of their life cycle and learn about their behavior, habitat, and conservation. The farm also features a souvenir shop, cafe, and guided tours, making it a fun and educational experience for visitors of all ages.", "https://lh5.googleusercontent.com/p/AF1QipNRPx_r6lpa0M1deRVNC_SXKPFxHdkKi19IDTeE=w1080-h624-n-k-no");
        Attraction penangStreetFood = new Attraction("Penang Street Food", georgeTown, "George Town is famous for its diverse and delicious street food, which reflects the multicultural heritage of Penang. Visitors can explore the city's hawker stalls, food courts, and open-air markets to sample a wide variety of dishes, including char kway teow, laksa, nasi kandar, and cendol. Some of the most popular street food destinations in George Town include Gurney Drive Hawker Centre, New Lane Hawker Centre, and Kimberley Street Night Market. Penang's street food scene offers a culinary adventure for food lovers, with flavors and aromas that will tantalize the taste buds.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSi69tPLFV2PWME5i-K--ymof4zOFLD7wDiIw&s");

        attractionRepository.save(penangHill);
        attractionRepository.save(streetArt);
        attractionRepository.save(penangPeranakanMansion);
        attractionRepository.save(penangButterflyFarm);
        attractionRepository.save(penangStreetFood);

// Top Attractions for Johar Bahru
        Attraction legolandMalaysiaResort = new Attraction("Legoland Malaysia Resort", johorBahru, "Legoland Malaysia Resort is a theme park located in Iskandar Puteri, Johor Bahru, Malaysia. It features a variety of attractions, including roller coasters, water rides, and interactive exhibits, all based on the popular Lego brand. Visitors can explore themed zones such as Lego City, Lego Technic, and Lego Kingdoms, and enjoy rides and attractions suitable for all ages. The resort also includes a water park, Legoland Water Park, and a themed hotel, Legoland Hotel, offering visitors a complete Lego-themed experience.", "https://lh5.googleusercontent.com/p/AF1QipMq5ptyEruVaBrqysAo4Mr0O06-50MXMByeXQWb=w1080-h624-n-k-no");
        Attraction johorBahruCitySquare = new Attraction("Johor Bahru City Square", johorBahru, "Johor Bahru City Square is a shopping mall located in the heart of Johor Bahru, Malaysia. It features a wide range of retail outlets, restaurants, and entertainment facilities, making it a popular destination for locals and tourists alike. Visitors can shop for a variety of goods, including clothing, electronics, and souvenirs, and dine at a selection of restaurants offering both local and international cuisine. The mall also hosts events and activities throughout the year, providing visitors with entertainment and leisure options.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/a7/5f/94/strategically-located.jpg?w=1200&h=1200&s=1");
        Attraction dangaBay = new Attraction("Danga Bay", johorBahru, "Danga Bay is a waterfront development located in Johor Bahru, Malaysia, along the Straits of Johor. It features a variety of attractions and recreational facilities, including parks, promenades, and water sports activities. Visitors can enjoy leisurely strolls along the waterfront, dine at waterfront restaurants offering panoramic views of the straits, or participate in activities such as jet skiing, kayaking, and paddle boating. Danga Bay is also a popular spot for picnics, family outings, and evening walks, offering visitors a relaxing escape from the city.", "https://tourismjohor.my/wp-content/uploads/2021/09/4--1024x711.jpg");
        Attraction puteriHarbourFamilyThemePark = new Attraction("Puteri Harbour Family Theme Park", johorBahru, "Puteri Harbour Family Theme Park is a family-friendly entertainment complex located in Iskandar Puteri, Johor Bahru, Malaysia. It features a variety of attractions and activities suitable for all ages, including amusement rides, indoor playgrounds, and themed attractions based on popular children's characters. Visitors can explore themed zones such as Sanrio Hello Kitty Town, Thomas Town, and The Little Big Club, and enjoy interactive experiences and live shows featuring beloved characters. The theme park also includes dining outlets, souvenir shops, and facilities for birthday parties and special events, making it a popular destination for families and children.", "https://thesmartlocal.com/reviews/media/reviews/photos/original/09/d0/29/puteri-harbour-family-theme-park-61-1374221678.jpg");
        Attraction johorZoo = new Attraction("Johor Zoo", johorBahru, "Johor Zoo is a zoological park located in Johor Bahru, Malaysia. It is home to a diverse collection of animals, including mammals, birds, reptiles, and fish, from Malaysia and around the world. Visitors can explore the zoo's exhibits, which include naturalistic habitats and interactive displays, and observe animals such as tigers, elephants, orangutans, and crocodiles. The zoo also offers educational programs, guided tours, and feeding sessions, providing visitors with opportunities to learn about wildlife conservation and biodiversity. Johor Zoo is a popular destination for families, school groups, and animal lovers, offering a fun and educational experience for visitors of all ages.", "https://lh5.googleusercontent.com/p/AF1QipO2qp3UYAByBfXf0O84ASc84gRDYBDfTVghKYMx=w1080-h624-n-k-no");

        attractionRepository.save(legolandMalaysiaResort);
        attractionRepository.save(johorBahruCitySquare);
        attractionRepository.save(dangaBay);
        attractionRepository.save(puteriHarbourFamilyThemePark);
        attractionRepository.save(johorZoo);

// Top Attractions for Ipoh
        Attraction lostWorldOfTambun = new Attraction("Lost World of Tambun", ipoh, "Lost World of Tambun is a theme park and hot springs resort located in Ipoh, Perak, Malaysia. It features a variety of attractions, including water slides, amusement rides, a petting zoo, and a natural hot springs spa. Visitors can explore themed zones such as Adventure Park, Water Park, and Tiger Valley, and enjoy activities such as cave exploration, zip-lining, and elephant encounters. The resort also includes accommodation options, dining outlets, and event spaces, making it a popular destination for families, thrill-seekers, and nature lovers alike.", "https://sunwaylostworldoftambun.com/wp-content/uploads/2022/04/DJI_0004-scaled.jpg");
        Attraction kintaRiverfrontWalk = new Attraction("Kinta Riverfront Walk", ipoh, "Kinta Riverfront Walk is a scenic promenade located along the Kinta River in Ipoh, Perak, Malaysia. It offers visitors a leisurely stroll amidst lush greenery, landscaped gardens, and picturesque river views. The walkway is lined with benches, pavilions, and public art installations, providing opportunities for relaxation and recreation. Visitors can enjoy activities such as jogging, cycling, or simply taking in the serene surroundings. Kinta Riverfront Walk is also a popular spot for photography, picnics, and outdoor events, making it a favorite destination for both locals and tourists.", "https://lh5.googleusercontent.com/p/AF1QipPG6Ql01RX8VevV9Ph9YsvlDbc9CrZZb8C6ptNU=w1080-h624-n-k-no");
        Attraction gunungLangRecreationalPark = new Attraction("Gunung Lang Recreational Park", ipoh, "Gunung Lang Recreational Park is a natural park located in Ipoh, Perak, Malaysia. It offers visitors a tranquil retreat amidst lush greenery, limestone hills, and scenic lakes. The park features walking trails, picnic areas, and viewing platforms, allowing visitors to explore its natural beauty and wildlife. Highlights of the park include a scenic lake with boat rides, a limestone hill with a lookout tower, and a canopy walkway through the treetops. Gunung Lang Recreational Park is a popular destination for nature lovers, bird watchers, and outdoor enthusiasts, offering opportunities for relaxation and adventure.", "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcS0XOnX74vrbi8CnezkSn12DXXwAIlt6IBntTNol5TyqKCmwAFROUm9JIm_1mi0UhE_M1IJKftWy36lq3TCw8TzdtE5vO-Ld-kgxwAAYGo");
        Attraction ipohRailwayStation = new Attraction("Ipoh Railway Station", ipoh, "Ipoh Railway Station is a historic train station located in Ipoh, Perak, Malaysia. Built-in 1917, it is known for its unique architecture, which combines Moorish, British colonial, and Malay influences. The station features a grand facade with domes, arches, and intricate details, making it one of the most photographed landmarks in Ipoh. Visitors can admire the station's exterior and interior design, which includes stained glass windows, marble floors, and antique furnishings. Ipoh Railway Station is still in use today and serves as a transportation hub for trains traveling between Kuala Lumpur and Penang.", "https://media-cdn.tripadvisor.com/media/photo-s/11/af/19/a4/ipoh-railway-station.jpg");
        Attraction ipohOldTown = new Attraction("Ipoh Old Town", ipoh, "Ipoh Old Town is a historic district located in the heart of Ipoh, Perak, Malaysia. It is known for its colonial-era architecture, bustling markets, and vibrant street art. Visitors can explore the district's narrow alleyways and heritage buildings, which house cafes, galleries, and boutique shops. Highlights of Ipoh Old Town include Concubine Lane, a narrow street lined with souvenir stalls and street food vendors, and Mural Art's Lane, which features colorful murals depicting scenes from Ipoh's history and culture. Ipoh Old Town is a popular destination for foodies, history buffs, and photographers, offering a glimpse into the city's rich heritage and cultural diversity.", "https://lh5.googleusercontent.com/p/AF1QipN0XRMspVKOsUDvsyjdVufT2iXRcXfiGc4MyT22=w1080-h624-n-k-no");

        attractionRepository.save(lostWorldOfTambun);
        attractionRepository.save(kintaRiverfrontWalk);
        attractionRepository.save(gunungLangRecreationalPark);
        attractionRepository.save(ipohRailwayStation);
        attractionRepository.save(ipohOldTown);

// Top Attractions for Kuching
        Attraction sarawakCulturalVillage = new Attraction("Sarawak Cultural Village", kuching, "Sarawak Cultural Village is a living museum located in Kuching, Sarawak, Malaysia. It showcases the diverse cultures and traditions of Sarawak's indigenous ethnic groups, including the Iban, Bidayuh, Orang Ulu, and Melanau. Visitors can explore traditional longhouses, watch cultural performances, and participate in hands-on activities such as cooking demonstrations, handicraft making, and blowpipe shooting. The village is set amidst lush tropical rainforest, providing visitors with an immersive experience in Sarawak's rich cultural heritage and natural beauty.", "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcRU7xwS4r_gqOh6yJzHQs3V90YOI0YrjYIFA6j29Egp7cQ1Ll1UHmFz0GtZXQucpjyNN_PVkAD_AV1C9SwVU9n0XiHjEVvekFHm8lcW-w");
        Attraction kuchingWaterfront = new Attraction("Kuching Waterfront", kuching, "Kuching Waterfront is a scenic promenade located along the Sarawak River in Kuching, Sarawak, Malaysia. It offers visitors panoramic views of the city skyline, historic landmarks, and traditional Malay kampong houses. The waterfront features a pedestrian walkway lined with cafes, restaurants, and souvenir shops, making it a popular spot for leisurely strolls, sunset watching, and boat cruises. Visitors can also explore nearby attractions such as the Sarawak State Legislative Assembly Building, Fort Margherita, and the Astana, the official residence of the Governor of Sarawak.", "https://thewaterfrontkuching.com/v3/wp-content/uploads/2019/09/shutterstock_1379583905-600x400.jpg");
        Attraction bakoNationalPark = new Attraction("Bako National Park", kuching, "Bako National Park is a protected area located on the Muara Tebas Peninsula in Kuching Division, Sarawak, Malaysia. It is known for its diverse ecosystems, including mangrove swamps, dipterocarp forests, and coastal cliffs, as well as its rich biodiversity, including proboscis monkeys, bearded pigs, and pitcher plants. Visitors can explore the park's network of hiking trails, which lead to scenic viewpoints, secluded beaches, and unique rock formations. Bako National Park is also a popular destination for wildlife spotting, birdwatching, and nature photography, offering visitors a chance to experience Sarawak's pristine natural beauty up close.", "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRAKHPMYN4G2vdxOKjMWj1pkzcqAo-M8Dm3Rar_6VeA4bP50qhx1iShy5U0O4h_lxmB5NV5ArJBoVs11cAi1iEg8N1oN8MzIrCruygHBg");
        Attraction semenggohNatureReserve = new Attraction("Semenggoh Nature Reserve", kuching, "Semenggoh Nature Reserve is a wildlife rehabilitation center located in Kuching Division, Sarawak, Malaysia. It is home to semi-wild orangutans that have been rescued from captivity or orphaned due to deforestation and illegal hunting. Visitors can observe the orangutans in their natural habitat during feeding times, which are held twice daily. The reserve also features lush rainforest trails, where visitors can spot other wildlife such as gibbons, hornbills, and monitor lizards. Semenggoh Nature Reserve plays a crucial role in orangutan conservation efforts in Sarawak, providing a safe haven for these endangered primates.", "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcSyyLA7D4HpcIF5YUhcx0aVrV8SYpZZ61wlPruV-WJo4yaMhuW4sbg-KO0nT8A2uvB5Q0N6LAD5_tyfv3rkKfuYgr6a3P28T1JHNT9k2ns");
        Attraction kubahNationalPark = new Attraction("Kubah National Park", kuching, "Kubah National Park is a protected area located in Kuching Division, Sarawak, Malaysia. It is known for its diverse ecosystems, including mixed dipterocarp forests, peat swamp forests, and montane forests, as well as its rich biodiversity, including rare orchids, pitcher plants, and endemic frogs. Visitors can explore the park's network of hiking trails, which lead to scenic waterfalls, natural pools, and panoramic viewpoints. Kubah National Park is also a popular destination for birdwatching, with over 100 species of birds recorded within the park's boundaries. The park offers visitors a chance to experience Sarawak's unique flora and fauna in a pristine rainforest setting.", "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcTpU8P9ZwjQql88EA9F4fQ0WI8M3g9b1l6qzKnis8S4vvdgLi8hPqRBxUy6GIf0GZH1pMFKVjtRoUjIZP5ggc-v_2pnX6d-njgnk5pnRw");

        attractionRepository.save(sarawakCulturalVillage);
        attractionRepository.save(kuchingWaterfront);
        attractionRepository.save(bakoNationalPark);
        attractionRepository.save(semenggohNatureReserve);
        attractionRepository.save(kubahNationalPark);

// Top Attractions for Seoul
        Attraction gyeongbokgungPalace = new Attraction("Gyeongbokgung Palace", seoul, "This historic palace is the largest of the Five Grand Palaces built during the Joseon Dynasty. Visitors can explore its impressive architecture, beautiful gardens, and learn about Korean royal history.", "https://afar.brightspotcdn.com/dims4/default/7ee59d2/2147483647/strip/false/crop/1600x800+0+0/resize/1486x743!/quality/90/?url=https%3A%2F%2Fk3-prod-afar-media.s3.us-west-2.amazonaws.com%2Fbrightspot%2F02%2Fbf%2Fa6b427fc47bb0fe4e702e1b859f1%2Foriginal-e30a5e10058c7167cd5e9cdcd65cc706.jpg");
        Attraction myeongdongShoppingStreet = new Attraction("Myeongdong Shopping Street", seoul, "A bustling district renowned for its vibrant blend of modernity and tradition. Lined with skyscrapers and neon signs, the narrow streets offer a sensory explosion of sizzling street food aromas and tantalizing Korean delicacies. It's a haven for fashion enthusiasts, with a maze of boutiques and international brands, alongside a paradise for beauty aficionados, boasting an array of cosmetics shops. Amidst the hustle, traditional hanok houses peek out, offering a glimpse into Seoul's rich heritage. As night falls, Myeongdong transforms into a pulsating hub of nightlife, with street performances and bustling night markets, making it an exhilarating destination for immersive cultural experiences.", "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/39/b3/15.jpg");
        Attraction nationalMuseumOfKorea = new Attraction("National Museum of Korea", seoul, "A cultural gem renowned for its vast collection spanning centuries of Korean history and art. Set against a backdrop of modern architecture, the museum offers a journey through the nation's rich heritage, from ancient artifacts to contemporary masterpieces. Visitors are immersed in a treasure trove of exhibits showcasing traditional ceramics, exquisite paintings, and archaeological wonders. The museum's sprawling grounds also feature tranquil gardens, providing a serene escape amidst the bustling city. With its comprehensive displays and immersive experiences, the National Museum of Korea stands as a beacon of cultural preservation and exploration.", "https://museu.ms/remote.jpg.ashx?width=1000&height=450&format=jpg&mode=crop&scale=both&404=no_image.gif&urlb64=aHR0cHM6Ly9tdXNldW1zLmJsb2IuY29yZS53aW5kb3dzLm5ldC9kYXRhL0RvY3VtZW50cy9NVVNFVU1TL3Nrc2VuYW11b2Zrby8zODQwNTcvYzAyOTYwNGRkOThkNDk4ZTkyZWU5ZGRmZDIyNmYyMmUuanBn&hmac=ePFx70L3IEE");
        Attraction changdeokgungPalace = new Attraction("Changdeokgung Palace", seoul, "A testament to Korea's majestic royal history. Surrounded by lush gardens and centuries-old trees, the palace exudes an aura of tranquility and grandeur. Its meticulously preserved architecture, characterized by intricate wooden structures and colorful painted details, offers visitors a glimpse into the opulent lifestyle of Korean royalty. As you wander through its graceful courtyards and ornate halls, you're transported back in time to a bygone era of splendor and tradition. Changdeokgung Palace, a UNESCO World Heritage site, stands as a timeless symbol of Korea's cultural heritage and architectural brilliance.", "https://img.jakpost.net/c/2017/08/14/2017_08_14_30987_1502708053._large.jpg");
        Attraction nSeoulTower = new Attraction("N Seoul Tower", seoul, "An iconic landmark perched atop Namsan Mountain in the heart of Seoul, offers panoramic views and cultural experiences that captivate visitors. Rising majestically above the city skyline, the tower's observation decks provide breathtaking vistas of Seoul's sprawling urban landscape and surrounding mountains. Beyond its awe-inspiring views, N Seoul Tower boasts an array of attractions, including restaurants, exhibitions, and even a digital art gallery, offering visitors a diverse range of experiences. Whether you're admiring the city lights at night or enjoying a leisurely stroll through the adjacent Namsan Park, N Seoul Tower stands as a symbol of Seoul's vibrant spirit and a must-visit destination for locals and tourists alike.", "https://www.kkday.com/en/blog/wp-content/uploads/kr_shutterstock_629824091.jpg");
        Attraction insadong = new Attraction("Insadong", seoul, "A cultural enclave nestled in the heart of Seoul, enchants visitors with its charming blend of tradition and modernity. Lined with quaint alleyways and historic storefronts, this bustling neighborhood is a treasure trove of Korean art, crafts, and cuisine. Meandering through its lively streets, visitors encounter a vibrant tapestry of galleries, teahouses, and souvenir shops, showcasing everything from traditional hanbok attire to contemporary artwork. Amidst the hustle and bustle, tranquil gardens provide serene retreats from the urban landscape, offering a glimpse into Seoul's rich cultural heritage. Whether savoring a cup of aromatic green tea or exploring the latest in Korean crafts, Insadong captivates with its timeless charm and vibrant energy.", "https://static.wixstatic.com/media/0505b9_e0e8b87de5644f53968ad29b7a953042~mv2.jpg/v1/fill/w_980,h_768,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/0505b9_e0e8b87de5644f53968ad29b7a953042~mv2.jpg");

        attractionRepository.save(gyeongbokgungPalace);
        attractionRepository.save(myeongdongShoppingStreet);
        attractionRepository.save(nationalMuseumOfKorea);
        attractionRepository.save(changdeokgungPalace);
        attractionRepository.save(nSeoulTower);
        attractionRepository.save(insadong);

// Top Attractions for Busan
        Attraction haeundaeBeach = new Attraction("Haeundae Beach", busan, "One of South Korea's most famous beaches, Haeundae Beach offers golden sands, clear waters, and a vibrant atmosphere. Visitors can enjoy sunbathing, swimming, and water sports during the day, and explore nearby cafes, restaurants, and bars along the bustling beachfront promenade. As night falls, the beach transforms into a lively hub of activity, with concerts, festivals, and fireworks lighting up the night sky.", "https://live.staticflickr.com/1576/26314850870_b08c11b9ef_b.jpg");
        Attraction gamcheonCultureVillage = new Attraction("Gamcheon Culture Village", busan, "Known as the 'Santorini of the East', Gamcheon Culture Village is a colorful hillside neighborhood in Busan, South Korea. Visitors can wander through its narrow alleys adorned with vibrant murals, art installations, and quirky sculptures, while enjoying panoramic views of the city and sea. The village is also home to galleries, cafes, and handicraft shops, offering a unique blend of art, culture, and community.", "https://www.visitbusan.net/uploadImgs/files/cntnts/20191229142305192_oen");
        Attraction busanTower = new Attraction("Busan Tower", busan, "Perched atop Yongdusan Park, Busan Tower is a symbol of the city's skyline and offers panoramic views of Busan's harbor and downtown area. Visitors can take an elevator to the observation deck, where they can enjoy breathtaking vistas of the city and sea, as well as visit the tower's museum and souvenir shop. At night, the tower is illuminated, creating a romantic atmosphere for couples and a captivating sight for visitors.", "https://i0.wp.com/blog.waug.com/wp-content/uploads/2020/09/busan-tower.jpg?fit=1200%2C675&ssl=1");
        Attraction gwangaliBeach = new Attraction("Gwangali Beach", busan, "A coastal gem nestled in the vibrant city of Busan, invites visitors to bask in its sun-kissed shores and captivating views. Stretching along the Gwangan Bridge, this sandy expanse offers a picturesque backdrop of shimmering waters and towering skyscrapers. Whether strolling along the palm-lined promenade, taking a dip in the refreshing sea, or indulging in fresh seafood delicacies at nearby cafes, Gwangalli Beach promises endless opportunities for relaxation and enjoyment. As day turns to night, the beach comes alive with vibrant lights and energetic nightlife, with bars and restaurants offering a lively atmosphere against the backdrop of the illuminated bridge. Gwangalli Beach embodies the essence of coastal charm and urban allure, making it a beloved destination for locals and tourists alike.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/e3/4e/f1/gwangalli-beach.jpg?w=1200&h=-1&s=1");

        attractionRepository.save(haeundaeBeach);
        attractionRepository.save(gamcheonCultureVillage);
        attractionRepository.save(busanTower);
        attractionRepository.save(gwangaliBeach);

// Top Attractions for Incheon
        Attraction songdoCentralPark = new Attraction("Songdo Central Park", incheon, "As the centerpiece of Songdo International Business District, Songdo Central Park is a green oasis amidst the city's urban landscape. Visitors can stroll along the park's walking paths, admire its scenic waterfront views, and relax in lush greenery. The park features recreational facilities, including playgrounds, cycling trails, and water taxis, making it a popular destination for families, couples, and outdoor enthusiasts.", "https://upload.wikimedia.org/wikipedia/commons/9/90/Songdo_Central_Park_in_2021.jpg");
        Attraction incheonChinatown = new Attraction("Incheon Chinatown", incheon, "Incheon Chinatown is the largest Chinatown in South Korea, offering a rich tapestry of Chinese culture, history, and cuisine. Visitors can explore its colorful streets lined with traditional Chinese buildings, and shops selling souvenirs and street food. The area is known for its vibrant atmosphere, with lantern festivals, cultural performances, and culinary events celebrating Chinese heritage.", "https://eatingandtraveling.com/wp-content/uploads/2017/04/img_5077.jpg?w=1200");
        Attraction wolmidoIsland = new Attraction("Wolmido Island", incheon, "Wolmido Island is a popular leisure destination in Incheon, offering scenic views, outdoor activities, and entertainment options. Visitors can take a ferry to the island and explore its waterfront promenades, amusement parks, and seafood restaurants. Wolmido also features cultural attractions such as the Incheon Port Lighthouse and Wolmi Theme Park, as well as opportunities for hiking, biking, and enjoying sunset views over the Yellow Sea.", "https://blog.trazy.com/wp-content/uploads/2019/11/incheon-wolmi-featured-image.jpg");
        Attraction incheonGrandPark = new Attraction("Incheon Grand Park", incheon, "Incheon Grand Park is a sprawling urban park that offers a tranquil retreat from the city's hustle and bustle. Visitors can explore its lush green spaces, scenic walking trails, and botanical gardens, which showcase a diverse range of plant species. The park also features recreational facilities, including picnic areas, playgrounds, and a zoo, making it a popular destination for families, nature lovers, and outdoor enthusiasts.", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/f0/9a/04/caption.jpg?w=1200&h=1200&s=1");
        Attraction incheonBridge = new Attraction("Incheon Bridge", incheon, "As one of the longest cable-stayed bridges in the world, Incheon Bridge is an iconic landmark that connects the mainland of Incheon to Yeongjong Island. Visitors can admire the bridge's sleek design and engineering marvels from various vantage points along the coast. The bridge is especially enchanting at night when it is illuminated by colorful lights, creating a stunning spectacle against the backdrop of the night sky.", "https://res.heraldm.com/content/image/2016/07/05/20160705001447_0.jpg");

        attractionRepository.save(songdoCentralPark);
        attractionRepository.save(incheonChinatown);
        attractionRepository.save(wolmidoIsland);
        attractionRepository.save(incheonGrandPark);
        attractionRepository.save(incheonBridge);



//        Reviews

        Review review2 = new Review(3,"Good stuff", zak,nerja);
        reviewRepository.save(review2);

        Review review3 = new Review(3,"Okay", zak,eiffelTower);
        reviewRepository.save(review3);
        Review review4 = new Review(4,"Good stuff", zak,eiffelTower);
        reviewRepository.save(review4);
        Review review5 = new Review(2,"Meh", zak,eiffelTower);
        reviewRepository.save(review5);
        Review review6 = new Review(1,"Horror", zak,eiffelTower);
        reviewRepository.save(review6);
        Review review7 = new Review(3,"Wow", zak,eiffelTower);
        reviewRepository.save(review7);
        
    }
}
