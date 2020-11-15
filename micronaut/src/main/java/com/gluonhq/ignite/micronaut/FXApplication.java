/*
 * Copyright (c) 2020, Gluon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.ignite.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.LifeCycle;
import io.micronaut.context.event.ApplicationEventPublisher;
import javafx.stage.Stage;

import java.util.Optional;

public final class FXApplication extends javafx.application.Application {

    private final ApplicationContext appContext = ApplicationContext.build().start();
    private final ApplicationEventPublisher publisher = appContext.getBean(ApplicationEventPublisher.class);

    @Override
    public void init()  {
        publisher.publishEvent(new InitEvent());
    }

    @Override
    public void start(Stage primaryStage) {
        publisher.publishEvent(new StartEvent(primaryStage));
    }

    @Override
    public void stop() {
        publisher.publishEvent(new StopEvent());
        Optional.of(appContext)
                .filter(LifeCycle::isRunning)
                .ifPresent(ApplicationContext::stop);
    }

    public static class InitEvent{}

    public static class StartEvent {
        private final Stage stage;

        public StartEvent(Stage stage) {
            this.stage = stage;
        }

        public Stage getStage() {
            return stage;
        }
    }

    public static class StopEvent{}

}


