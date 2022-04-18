package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        int position = Integer.parseInt(intent.getStringExtra("com.example.android.extra.MESSAGE"));
        TextView textView = findViewById(R.id.description_text_view);
        textView.setText(getContent(position));
    }

    String getContent(int position){
        String content = "";
        if (position == 0){
            content = "Fruit Pizza\n" +
                    "\n" +
                    "TOTAL TIME: 1 hour 30 minutes\n" +
                    "YIELD: 8 big slices\n" +
                    "\n" +
                    "This simple fruit pizza is beautiful and delicious! A soft sugar cookie crust with a cream cheese frosting and topped with sliced fruit. So simple and oh-so good!\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "Sugar Cookie Crust:\n" +
                    "3/4 cup sugar\n" +
                    "1 1/4 cups flour\n" +
                    "1/4 teaspoon baking powder\n" +
                    "1/4 teaspoon salt\n" +
                    "1/2 cup butter, softened\n" +
                    "1 teaspoon vanilla extract\n" +
                    "1 large egg\n" +
                    "\n" +
                    "Cream Cheese Frosting:\n" +
                    "12 ounces cream cheese, softened\n" +
                    "1/4 cup butter, softened\n" +
                    "1 teaspoon vanilla\n" +
                    "1 1/4 cup powdered sugar\n" +
                    "\n" +
                    "Fruit Toppings:\n" +
                    "7–10 strawberries, sliced\n" +
                    "5–6 kiwis, sliced\n" +
                    "1 mango, sliced\n" +
                    "1/2 cup blueberries\n" +
                    "1 small bunch of grapes, halved\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Make the Crust: Mix the butter, sugar, egg, and vanilla until well combined. (You can use an electric mixer or just mix with a spoon if your butter is melted.) Add flour, baking powder, and salt. Mix until combined. Chill the dough for 30 minutes.\n" +
                    "2. Bake the Crust: Preheat the oven to 350 degrees. Grease a 14-inch pizza pan or round baking stone, or line with parchment. Roll the chilled dough out onto it, leaving some space around the edge. Bake for 12 minutes. Allow it to cool.\n" +
                    "3. Make the Cream Cheese Frosting: Using an electric mixer, combine the cream cheese, butter, powdered sugar and vanilla until smooth and creamy. Spread over the cooled cookie crust and chill again to firm up the frosting.\n" +
                    "4. Make It Fancy: Top with fruit! See post for designs.";
        }
        else if (position == 1){
            content = "The Best Soft Chocolate Chip Cookies\n" +
                    "\n" +
                    "TOTAL TIME: 20 minutes\n" +
                    "YIELD: 12 cookies\n" +
                    "\n" +
                    "These are THE BEST soft chocolate chip cookies! No chilling required. Just ultra thick, soft, classic chocolate chip cookies!\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "8 tablespoons of salted butter\n" +
                    "1/2 cup white sugar (I like to use raw cane sugar with a coarser texture)\n" +
                    "1/4 cup packed light brown sugar\n" +
                    "1 teaspoon vanilla\n" +
                    "1 egg\n" +
                    "1 1/2 cups all purpose flour (more as needed – see video)\n" +
                    "1/2 teaspoon baking soda\n" +
                    "1/4 teaspoon salt (but I always add a little extra)\n" +
                    "3/4 cup chocolate chips (I use a combination of chocolate chips and chocolate chunks)\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Preheat the oven to 350 degrees. Microwave the butter for about 40 seconds to just barely melt it. It shouldn’t be hot – but it should be almost entirely in liquid form.\n" +
                    "2. Using a stand mixer or electric beaters, beat the butter with the sugars until creamy. Add the vanilla and the egg; beat on low speed until just incorporated – 10-15 seconds or so (if you beat the egg for too long, the cookies will be stiff).\n" +
                    "3. Add the flour, baking soda, and salt. Mix until crumbles form. Use your hands to press the crumbles together into a dough. It should form one large ball that is easy to handle (right at the stage between “wet” dough and “dry” dough). Add the chocolate chips and incorporate with your hands.\n" +
                    "4. Roll the dough into 12 large balls (or 9 for HUGELY awesome cookies) and place on a cookie sheet. Bake for 9-11 minutes until the cookies look puffy and dry and just barely golden.Warning, friends: DO NOT OVERBAKE. This advice is probably written on every cookie recipe everywhere, but this is essential for keeping the cookies soft. Take them out even if they look like they’re not done yet (see picture in the post). They’ll be pale and puffy.\n" +
                    "5. Let them cool on the pan for a good 30 minutes or so (I mean, okay, eat four or five but then let the rest of them cool). They will sink down and turn into these dense, buttery, soft cookies that are the best in all the land. These should stay soft for many days if kept in an airtight container. I also like to freeze them.";
        }
        else if (position == 2){
            content = "Blender Lemon Pie\n" +
                    "\n" +
                    "TOTAL TIME: 1 hour 15 minutes\n" +
                    "YIELD: 10 slices\n" +
                    "\n" +
                    "Blender Lemon Pie! Eggs, butter, sugar, and a WHOLE LEMON blended up and poured into a crust. Springy, custardy, simple lemon magic.\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "4 Simply Nature Organic Cage Free Grade A Large Brown Eggs\n" +
                    "1/2 cup Countryside Creamery Salted Butter, melted\n" +
                    "1 whole lemon (see notes)\n" +
                    "1 1/4 cups Simply Nature Organic Cane Sugar\n" +
                    "splash of vanilla (optional)\n" +
                    "unbaked 9-inch Bake House Creations Pie Crust\n" +
                    "powdered sugar and lemon slices for garnish\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Prep: Preheat the oven to 350 degrees.\n" +
                    "2. Blend: Cut the lemon into sections so you can remove the seeds. Put everything in the blender (yes, the whole lemon, rind and everything!) and blend until very smooth. You may still have some very small flecks of lemon rind – that’s great.\n" +
                    "3. Bake: Unroll pie crust and press into a 9-inch pie pan. Pour filling into the pie crust. Bake for 45 minutes or until set. Dust with powdered sugar and fancify the whole thing with a lil lemon slice or twist. Serve warm (it’ll be a little looser) or chilled for about 2 hours (thicker, more dense, and my personal preference).";
        }
        else if (position == 3){
            content = "Modern Scotcheroos\n" +
                    "\n" +
                    "TOTAL TIME: 20 minutes\n" +
                    "YIELD: 16 servings\n" +
                    "\n" +
                    "The classic chocolate covered peanut butter rice krispie bars, but with minimal refined sugar thanks to a few modern swaps. It’s a peanut butter meets chocolate situation, so obviously, your people will love you.\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "1 cup brown rice syrup <- order on Amazon because you’re a queen and Amazon is life\n" +
                    "1 cup peanut butter\n" +
                    "1/4 cup real maple syrup\n" +
                    "6 cups brown rice krispies\n" +
                    "1 24–ounce bag of dark chocolate chips\n" +
                    "a generous pinch of flaked sea salt <- again, may I suggest Amazon\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Rice Krispie Mixture: Melt brown rice syrup, peanut butter, and maple syrup in a large pot until a smooth mixture forms. Add a pinch of sea salt and stir in the brown rice krispies. Remove from heat and press into a 9×13 pan.\n" +
                    "2. Chocolate Topping: Melt chocolate chips gently and slowly (preferably in a double boiler, or, in my case, a random stainless steel bowl fitted inside a pot of simmering water, but microwave or regular saucepan works, too). Pour chocolate over the rice krispie mixture and sprinkle again – !! – with sea salt because you don’t want to hate your life. Rest at room temperature until chocolate is set and watch them disappear.\n";
        }
        else if (position == 4){
            content = "Raspberry Crumble Bars\n" +
                    "\n" +
                    "TOTAL TIME: 1 hour 30 minutes\n" +
                    "YIELD: 12–18 bars\n" +
                    "\n" +
                    "These Raspberry Crumble Bars are THE BEST! So soft, buttery, and delicious. My favorite summer dessert.\n" +
                    "\n" +
                    "Raspberry Filling\n" +
                    "\n" +
                    "two 12-ounce bags of frozen raspberries (see notes)\n" +
                    "1/2 cup granulated sugar (more depending on tartness of your berries)\n" +
                    "2 tablespoons flour\n" +
                    "1 tablespoon cornstarch\n" +
                    "juice of one lemon\n" +
                    "\n" +
                    "Crumble Layer\n" +
                    "\n" +
                    "3 cups rolled oats\n" +
                    "3 cups flour\n" +
                    "2 cups brown sugar (loosely packed)\n" +
                    "1 teaspoon baking powder\n" +
                    "1 1/2 cups melted butter (I prefer salted)\n" +
                    "1/2 teaspoon salt\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Prep Raspberries: Preheat the oven to 350 degrees. Place raspberries in a large colander. Run warm water over them for a minute, and then let the liquid drain out for about an hour until softened and thoroughly drained (see notes). Mix raspberries with sugar, flour, cornstarch, and lemon juice.\n" +
                    "2. Soft Delicious Crust: Mix the oats, flour, sugar, baking powder, butter, and salt together into a crumble-like mixture. Press two thirds of the crumble into the bottom of a 9×13 pan lined with parchment paper. Bake for 10 minutes.\n" +
                    "3. Bake: Arrange the raspberry layer on top of the baked bottom layer. Sprinkle with remaining crumble. Bake for another 25-30 minutes.\n" +
                    "4. Finish: Remove from oven. They will need a little time to set up into “bar” formation, so chill them for a few hours to get them really solid. Orrrr… cut into it right away and eat it like a soft fruit crisp! You should be able to remove them from the pan easily by pulling up on the edges of the parchment paper.";
        }
        else if (position == 5){
            content = "Mind-Blowing Vegan Chocolate Pie\n" +
                    "\n" +
                    "TOTAL TIME: 10 minutes\n" +
                    "YIELD: 10 slices\n" +
                    "\n" +
                    "This vegan chocolate pie is a five-ingredient, no-bake miracle. The ultra-thick and creamy chocolate pie filling is made with (wait for it)… tofu, almond butter, almondmilk, and melted chocolate. Easy!\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "For the chocolate pie filling:\n" +
                    "\n" +
                    "12 ounces firm silken firm tofu\n" +
                    "1/2 cup Almond Breeze Chocolate Almondmilk\n" +
                    "1/2 cup almond butter\n" +
                    "12 ounces chocolate chips*\n" +
                    "flaky sea salt for topping\n" +
                    "\n" +
                    "For the Crust:\n" +
                    "\n" +
                    "pie crust of your choice! ideas in the notes section.\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Chocolate Pie Filling: Blend the tofu, almondmilk, and almond butter until smooth. Melt the chocolate chips. Add to the blender and blend until smooth – it gets pretty thick so you might need to help it along with a spatula between blends.\n" +
                    "2. Chocolate Pie Assembly: Pour filling into a crust, sprinkle with sea salt if you want, and chill for 12-24 hours. Cut and serve!\n";
        }
        else if (position == 6){
            content = "Gooey Caramel Monkey Bread\n" +
                    "\n" +
                    "TOTAL TIME: 2 hours 25 minutes\n" +
                    "YIELD: 10\n" +
                    "\n" +
                    "This Gooey Caramel Monkey Bread is LOADED with homemade caramel sauce and made with a pillowy homemade brioche dough. Perfect made-from-scratch, crowd-pleasing recipe that is conveniently low-maintenance. Just how I like it.\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "For the Dough:\n" +
                    "\n" +
                    "1 cup lukewarm water\n" +
                    "1 packet instant yeast (about 2 teaspoons)\n" +
                    "2 teaspoons salt\n" +
                    "1/4 cup honey or sugar\n" +
                    "4 large eggs\n" +
                    "3/4 cup butter (melted)\n" +
                    "4 1/2 cups flour (more for dusting)\n" +
                    "\n" +
                    "You can also just use canned biscuit dough if you prefer, but I strongly recommend making your dough from scratch! The smells! The pillowy texture! Worth it.\n" +
                    "\n" +
                    "For the Caramel Sauce:\n" +
                    "\n" +
                    "1/2 cup butter (I prefer salted)\n" +
                    "1/2 cup heavy whipping cream\n" +
                    "1 1/2 cups brown sugar\n" +
                    "a hit of sea salt if you like that kinda thing\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Make the Dough: Mix all the dough ingredients together in a mixing bowl, adding flour last. The mixture will be sticky. Cover loosely with plastic wrap or a damp towel. Set aside in a warm-ish place to rise for 2 hours. Once it has risen, transfer to the fridge to chill so it’s easier to handle.\n" +
                    "2. Roll the Dough: When the dough has chilled, roll out half of it on a floured surface to a medium thickness. Cut it into bite-sized pieces or roll into balls. Wrap the other half of the dough in plastic wrap and store in the freezer for next time.\n" +
                    "3. Make the Sauce: Melt the butter, heavy cream, and brown sugar in a saucepan. Bring to a boil, stirring constantly, and heat for exactly five minutes. Remove from heat.\n" +
                    "4. Assemble: In a bundt® pan or pie pan, layer: 1/4 cup caramel sauce, dough, 1/4 cup caramel sauce, dough, 1/4 cup caramel sauce. Reserve the remaining sauce.\n" +
                    "5. Bake: Bake for 25-30 minutes at 350 degrees or until the top pieces are browning a little bit. Invert onto a serving plate and top with extra sauce if you want (um, yes, I DO WANT). Enjoy!\n";
        }
        else if (position == 7){
            content = "Raw Salted Chocolate Snack Bars\n" +
                    "\n" +
                    "TOTAL TIME: 25 minutes\n" +
                    "YIELD: 12–14\n" +
                    "\n" +
                    "Salted Chocolate Snack Bars with simple clean ingredients: pecans, oats, dates, cocoa powder, coconut oil, and maple syrup. SO GOOD!\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "Crust:\n" +
                    "\n" +
                    "1 1/2 cup pecan halves\n" +
                    "1 1/2 cup rolled oats\n" +
                    "8 whole medjool dates, pitted\n" +
                    "1/2 cup coconut oil, melted\n" +
                    "a pinch of coarse sea salt\n" +
                    "\n" +
                    "Chocolate Filling Layer:\n" +
                    "\n" +
                    "1/2 cup cocoa powder\n" +
                    "1/4 cup coconut oil, melted\n" +
                    "1/4 cup liquid sweetener – agave, maple syrup, or honey (more or less to taste)\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Crust: Pulse all ingredients for the crust in a food processor until a sticky dough mixture forms. Set aside about 3/4 cup crust mixture. Press the remaining crust mixture into a 9×5 loaf pan lined with parchment paper.\n" +
                    "2. Chocolate: Whisk the chocolate filling ingredients in a small mixing bowl until smooth. Pour over crust.\n" +
                    "3. Topping: Sprinkle remaining crust on top and press gently to get it to stay put in the chocolate mixture. Sprinkle with extra sea salt if you’re obsessed with sea salt not that I know a-ny-thing about that.\n" +
                    "4. Chill: Place the whole thing in the freezer and chill for 2 hours. Cut into bars and serve!";
        }
        else if (position == 8){
            content = "Carrot Cake Coffee Cake\n" +
                    "\n" +
                    "TOTAL TIME: 55 minutes\n" +
                    "YIELD: 8–10 servings\n" +
                    "\n" +
                    "Carrot Cake Coffee Cake! A super easy batter loaded with shredded carrots, topped with a thick crumbly cinnamony streusel, and finished with a melty sweet honey butter.\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "Carrot Cake Coffee Cake:\n" +
                    "\n" +
                    "2 large carrots\n" +
                    "3/4 cup granulated sugar\n" +
                    "1/2 cup butter, melted\n" +
                    "2 eggs\n" +
                    "1 cup flour\n" +
                    "1 teaspoon baking soda\n" +
                    "1 teaspoon cinnamon\n" +
                    "pinch of salt\n" +
                    "\n" +
                    "Streusel Topping:\n" +
                    "\n" +
                    "4 tablespoons butter, melted\n" +
                    "1/2 cup flour\n" +
                    "1/2 cup brown sugar\n" +
                    "1 teaspoon cinnamon\n" +
                    "pinch of salt\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Prep: Preheat the oven to 350 degrees. Peel and grate the carrots (I use my food processor). You should have about 1 1/2 cups.\n" +
                    "2. Cake Batter: Whisk sugar, melted butter, and eggs. Stir in carrots. Add flour, baking soda, and cinnamon. Mix until just combined. The batter will be very thick.\n" +
                    "3. Streusel: Mix ingredients for the streusel until you get a texture that looks like pebbles (sometimes I use my hands to mix it all together).\n" +
                    "4. Bake: Spread batter into a greased 9-inch round baking pan (see FAQs). Sprinkle with streusel. Bake for 30 minutes until the center is just set. Top with honey butter if you’re extra (you are).";
        }
        else if (position == 9){
            content = "Almond Butter Cups\n" +
                    "\n" +
                    "TOTAL TIME: 1 hour 10 minutes\n" +
                    "YIELD: 12 medium/large almond butter cups\n" +
                    "\n" +
                    "Almond Butter Cups: made with five ingredients and no refined sugar. So creamy, rich, and yummy!\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "3/4 cup melted coconut oil\n" +
                    "1/2 cup cocoa powder (more or less to taste)\n" +
                    "2–4 tablespoons natural sweetener (I like agave or maple syrup – more or less to taste)\n" +
                    "pinch of salt\n" +
                    "roughly 3/4 cup of almond butter (or any nut butter)\n" +
                    "sea salt for topping\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Whisk the coconut oil, cocoa powder, sweetener, and a pinch of salt.\n" +
                    "2. Fill a regular size muffin tin with paper liners. Pour a small amount of the cocoa mixture (1-2 tablespoons) into the paper cups. Drop a small spoonful of the almond butter (2-3 teaspoons) into the center of each cup. Divide remaining chocolate amongst the cups.\n" +
                    "3. If almond butter is sticking up, just gently press it down so each cup has a smooth top layer. Sprinkle each almond butter cup with a pinch of coarse sea salt. Freeze for one hour or until solid. YUM TOWN.";
        }
        else if (position == 10){
            content = "Best Peach Cobbler\n" +
                    "\n" +
                    "TOTAL TIME: 1 hour\n" +
                    "YIELD: 8 servings\n" +
                    "\n" +
                    "I have tried so many peach cobbler recipes and this is by far the BEST peach cobbler! Made with fresh peaches, sugar, and a topping that bakes like slightly underbaked cookie dough, with crunchy sugar broiled on top.\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "Peach Filling\n" +
                    "\n" +
                    "5–6 large fresh yellow peaches, sliced\n" +
                    "1/4 cup sugar\n" +
                    "\n" +
                    "Cobbler Topping\n" +
                    "\n" +
                    "1/2 cup salted butter, melted\n" +
                    "3/4 cup sugar\n" +
                    "1 teaspoon vanilla\n" +
                    "1 cup flour\n" +
                    "1 teaspoon baking powder\n" +
                    "a pinch of salt\n" +
                    "1/4 cup turbinado sugar (optional, but really nice)\n" +
                    "whipped cream or vanilla ice cream for serving\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Preheat the oven to 350 degrees. Smear the bottom of 9×13 pan with a little bit of butter. Add peaches and sugar, and mix directly in the pan.\n" +
                    "2. Mix the butter, sugar, vanilla, flour, baking powder, and salt until a cookie-dough-like batter forms.\n" +
                    "3. Place scoops of the mixture over the top of the peaches. Spread with a spoon or with your fingers – no need for perfection here.\n" +
                    "4. Bake for 30 minutes. At this point it should be juicy and bubbly around the sides – if not, see notes.\n" +
                    "5. Sprinkle the top with turbinado sugar. Bake another 10 minutes and then finish with a few minutes under the broiler (475-ish) for a few minutes to get it golden brown and slightly crunchy on top.\n" +
                    "6. To get a thick saucy peach base, let it stand for 20-30 minutes before serving with some vanilla ice cream. But good luck with that. ";
        }
        else if (position == 11){
            content = "Salted Caramel Brownies\n" +
                    "\n" +
                    "TOTAL TIME: 1 hour\n" +
                    "YIELD: 9 big brownies\n" +
                    "\n" +
                    "Salted Caramel Brownies ♡ thick, dense, fudgy brownies stuffed with homemade salted caramel. HEAVEN.\n" +
                    "\n" +
                    "INGREDIENTS\n" +
                    "\n" +
                    "Yummy Homemade Caramel:\n" +
                    "\n" +
                    "1/2 cup sugar\n" +
                    "4 tablespoons salted butter\n" +
                    "3 tablespoons heavy cream\n" +
                    "pinch of salt\n" +
                    "\n" +
                    "Fudgy Thick Brownies:\n" +
                    "\n" +
                    "4 ounces unsweetened chocolate (one bar)\n" +
                    "1 stick salted butter (8 tablespoons)\n" +
                    "1 cup sugar\n" +
                    "2 eggs\n" +
                    "1 teaspoon vanilla\n" +
                    "3/4 cup flour\n" +
                    "pinch of salt\n" +
                    "\n" +
                    "INSTRUCTIONS\n" +
                    "\n" +
                    "1. Prep: Preheat oven to 350. Line a flat plate with parchment paper and coat with cooking spray. Line an 8×8 square baking pan with parchment paper and coat with cooking spray.\n" +
                    "2. Make that caramel: place the sugar in a small saucepan over medium high heat. Stir frequently – the sugar will form clumps and eventually become smooth. Remove from heat. Add butter and stir in. Add cream and stir in. Return to heat – let it get smooth and bubbly for another few minutes. Pour the caramel on the parchment-lined plate. Freeze for 20-30 minutes to solidify.\n" +
                    "3. Brownie time: Melt the chocolate and the butter (microwave or double boiler). Whisk in the sugar. Whisk in the eggs and vanilla. Whisk in the flour and salt.\n" +
                    "4. Caramel meets brownie: Cut the cooled caramel into small squares. Stir most of them into the brownie batter and transfer to the pan. Arrange the last few caramel pieces on top of the brownies. Bake for 30 minutes (more or less to taste). Cool in the fridge or freezer for easier cutting. FALL IN LOVE!";
        }
        return content;
    }
}